<?php

namespace GameBundle\Controller;

use GameFrontBundle\Entity\Game;
use GameFrontBundle\Entity\Team;
use http\Env\Response;
use GameFrontBundle\Controller\TeamController;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;
use Symfony\Component\Form\Form;

class GameController extends Controller
{
    private $url="http://api.football-data.org/v1/fixtures";

    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $games = $em->getRepository('GameFrontBundle:Game')->findAll();

        return $this->render('@Game/index.html.twig', array(
            'games' => $games,
        ));
    }


    public function newAction(Request $request)
    {
        $game = new Game();
        $form = $this->createForm('GameFrontBundle\Form\TeamType', $game);

        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($game);
            $em->flush();

        }

        return $this->render('@Game/new.html.twig', array(
            'game' => $game,
            'form' => $form->createView(),
        ));
    }


    public function showAction(Game $game)
    {
        $deleteForm = $this->createDeleteForm($game);

        return $this->render('@Game/show.html.twig', array(
            'game' => $game,
            'delete_form' => $deleteForm->createView(),
        ));
    }


public function PointsCount($id) {
    //get both teams
    $em = $this->getDoctrine()->getManager();
    $game = $em->getRepository('GameFrontBundle:Game')->find($id);
    $TOne=$game->getGameWinnerteam();
    $TTwo=$game->getGameLossteam();

    $t1 = $em->getRepository('GameFrontBundle:Team')->findOneBy(['teamName' => $TOne] );
    $t2 = $em->getRepository('GameFrontBundle:Team')->findOneBy(['teamName' => $TTwo] );


    //team one goals for and against
    $t1->setTeamGoalsfor($t1->getTeamGoalsfor() + $game->getGameWinnerteamscore());
    $t1->setTeamGoalsagainst($t1->getTeamGoalsagainst() + $game->getGameLossteamscore());
    //team two goals for and against
    $t2->setTeamGoalsfor($t2->getTeamGoalsfor() + $game->getGameLossteamscore());
    $t2->setTeamGoalsagainst($t2->getTeamGoalsagainst() + $game->getGameWinnerteamscore());
    //Number of match played
    $t1->setTeamIntmatchplayed($t1->getTeamIntmatchplayed() + 1);
    $t2->setTeamIntmatchplayed($t2->getTeamIntmatchplayed() + 1);
if (strpos($game->getGameKind(), 'Group') !== false) {
    //Count Points
if ($game->getGameWinnerteamscore() > $game->getGameLossteamscore()) {
    $t1->setTeamPoints($t1->getTeamPoints() + 3);
    $t1->setTeamIntmatchwon($t1->getTeamIntmatchwon() + 1);
    $t2->setTeamIntmatchlost($t2->getTeamIntmatchlost() + 1);
} else if ($game->getGameWinnerteamscore() < $game->getGameLossteamscore()) {
    $t2->setTeamPoints($t2->getTeamPoints() + 3);
    $t2->setTeamIntmatchwon($t2->getTeamIntmatchwon() + 1);
    $t1->setTeamIntmatchlost($t1->getTeamIntmatchlost() + 1);
} else {
    $t1->setTeamPoints($t1->getTeamPoints() + 1);
    $t2->setTeamPoints($t2->getTeamPoints() + 1);
    $t1->setTeamIntmatchdraw($t1->getTeamIntmatchdraw() + 1);
    $t2->setTeamIntmatchdraw($t2->getTeamIntmatchdraw() + 1);
}
//update database (table team)

        } else //if not in group stage
        {
            if ($game->getGameWinnerteamscore() > $game->getGameLossteamscore()) {
                $t1->setTeamIntmatchwon($t1->getTeamIntmatchwon() + 1);
                $t2->setTeamIntmatchlost($t2->getTeamIntmatchlost() + 1);
            } else if ($game->getGameWinnerteamscore() < $game->getGameLossteamscore()) {
                $t2->setTeamIntmatchwon($t2->getTeamIntmatchwon() + 1);
                $t1->setTeamIntmatchlost($t1->getTeamIntmatchlost() + 1);
            } else {
                $t1->setTeamIntmatchdraw($t1->getTeamIntmatchdraw() + 1);
                $t2->setTeamIntmatchdraw($t2->getTeamIntmatchdraw() + 1);
            }
        }
    }


    public function editAction(Request $request, Game $game)
    {
        $deleteForm = $this->createDeleteForm($game);
        $editForm = $this->createForm('GameFrontBundle\Form\GameType', $game);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {
            $this->PointsCount($game->getGameId());
            $this->getDoctrine()->getManager()->flush();
            return $this->redirectToRoute('game_edit', array('gameId' => $game->getGameid()));
        }




        return $this->render('@Game/edit.html.twig', array(
            'game' => $game,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    public function deleteAction(Request $request, Game $game)
    {
        $form = $this->createDeleteForm($game);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->remove($game);
            $em->flush();
        }

        return $this->redirectToRoute('game_index');
    }


    private function createDeleteForm(Game $game)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('game_delete', array('gameId' => $game->getGameid())))
            ->setMethod('DELETE')
            ->getForm()
        ;
    }

        private function getContext()
        {
            $opts= array("http" => array("method" => "GET" , "header"=>"X-Auth-Token" , "8027288c32024916bd9f381847429491"));
            $context=@stream_context_create($opts);
            return $context;
        }

    public function parseDataAction()
    {
        $context = $this->getContext();
        $data = json_decode(@file_get_contents($this->url,true,$context),true);
        $em=$this->getDoctrine()->getManager();
        foreach ($data['fixtures'] as $game)
        {
            $team=$em->getRepository('GameFrontBundle:Team')->findOneByTeamName($game['homeTeamName']);
            if (!$team)
            {
                $team=new Team();
                $team->setTeamName($game['homeTeamName']);
                $em->persist($team);
                $em->flush();

            }
            $team=$em->getRepository('GameFrontBundle:Team')->findOneByTeamName($game['awayTeamName']);
            if (!$team)
            {
                $team=new Team();
                $team->setTeamName($game['awayTeamName']);
                $em->persist($team);
                $em->flush();

            }
        }
        return new Response('completed');

    }
}

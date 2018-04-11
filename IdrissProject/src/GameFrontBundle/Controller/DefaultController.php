<?php

namespace GameFrontBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use GameFrontBundle\Entity\Game;
use GameFrontBundle\Entity\Team;
use Symfony\Component\HttpFoundation\Request;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('GameFrontBundle::index.html.twig');
    }

    public function pointsAction()
    {
        $em = $this->getDoctrine()->getManager();
        $teams = $em->getRepository('GameFrontBundle:Team')->findAll();
        return $this->render('@GameFront/points-table.html.twig', array(
            'teams' => $teams,
        ));
    }

    public function resultAction()
    {
        $em = $this->getDoctrine()->getManager();
        $games = $em->getRepository(Game::class)->findAll();
        return $this->render('@GameFront/results.html.twig',['games' => $games]
            );
    }

    public function singleResultAction($id)
    {
        $em = $this->getDoctrine()->getManager();
        $game = $em->getRepository('GameFrontBundle:Game')->find($id);
        $TOne=$game->getGameWinnerteam();
        $TTwo=$game->getGameLossteam();

        $teamOne = $em->getRepository('GameFrontBundle:Team')->findOneBy(['teamName' => $TOne] );
        $teamTwo = $em->getRepository('GameFrontBundle:Team')->findOneBy(['teamName' => $TTwo] );

        return $this->render('@GameFront/single.html.twig', array(
            'game' => $game,'teamOne' => $teamOne,'teamTwo' => $teamTwo
        ));
    }

    public function allAction()
    {
        $em = $this->getDoctrine()->getManager();

        $games = $em->getRepository('GameBundle:Game')->findAll();

        return $this->render('@Game/index.html.twig', array(
            'games' => $games,
        ));
    }


    public function newAction(Request $request)
    {
        $game = new Game();
        $form = $this->createForm('GameBundle\Form\GameType', $game);
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


    public function editAction(Request $request, Game $game)
    {
        $deleteForm = $this->createDeleteForm($game);
        $editForm = $this->createForm('GameBundle\Form\GameType', $game);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {
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

}

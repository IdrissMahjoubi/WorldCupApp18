<?php

namespace AppBundle\Controller;

use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\RedirectResponse;

class DefaultController extends Controller
{

    public function indexAction(Request $request)
    {
        return $this->render('@App/index.html.twig');

    }

    public function checkAction(Request $request)
    {
        $authChecker = $this->container->get('security.authorization_checker');
        $router = $this->container->get('router');

        if ($authChecker->isGranted('ROLE_ADMIN')) {
            return new RedirectResponse($router->generate('game_index'), 307);
        }

        if ($authChecker->isGranted('ROLE_USER')) {
            return new RedirectResponse($router->generate('game_front_homepage'), 307);
        }

    }
}



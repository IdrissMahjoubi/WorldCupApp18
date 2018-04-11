<?php

namespace GameFrontBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Goal
 *
 * @ORM\Table(name="GOAL")
 * @ORM\Entity
 */
class Goal
{
    /**
     * @var integer
     *
     * @ORM\Column(name="GOAL_GAME", type="integer", nullable=true)
     */
    private $goalGame;

    /**
     * @var integer
     *
     * @ORM\Column(name="GOAL_PLAYER", type="integer", nullable=true)
     */
    private $goalPlayer;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="GOAL_TIME", type="time", nullable=false)
     */
    private $goalTime;

    /**
     * @var integer
     *
     * @ORM\Column(name="GOAL_ID", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $goalId;


}


<?php

namespace GameFrontBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Team
 *
 * @ORM\Table(name="TEAM")
 * @ORM\Entity(repositoryClass="GameFrontBundle\Repository\TeamRepository")
 */
class Team
{

    /**
     * @var \GameFrontBundle\Entity\Game
     *
     * @ORM\ManyToOne(targetEntity="GameFrontBundle\Entity\Game")
     * @ORM\JoinColumn(name="game_id",referencedColumnName="GAME_ID")
     *
     */
    private $game;

    /**
     * @var string
     *
     * @ORM\Column(name="TEAM_NAME", type="string", length=45, nullable=true)
     */
    private $teamName;

    /**
     * @var string
     *
     * @ORM\Column(name="TEAM_COACH", type="string", length=45, nullable=true)
     */
    private $teamCoach;

    /**
     * @var integer
     *
     * @ORM\Column(name="TEAM_INTMATCHPLAYED", type="integer", nullable=true)
     */
    private $teamIntmatchplayed = '0';

    /**
     * @var integer
     *
     * @ORM\Column(name="TEAM_INTMATCHWON", type="integer", nullable=true)
     */
    private $teamIntmatchwon = '0';

    /**
     * @var integer
     *
     * @ORM\Column(name="TEAM_INTMATCHLOST", type="integer", nullable=true)
     */
    private $teamIntmatchlost = '0';

    /**
     * @var integer
     *
     * @ORM\Column(name="TEAM_INTMATCHDRAW", type="integer", nullable=true)
     */
    private $teamIntmatchdraw = '0';

    /**
     * @var integer
     *
     * @ORM\Column(name="TEAM_GOALSFOR", type="integer", nullable=true)
     */
    private $teamGoalsfor = '0';

    /**
     * @var integer
     *
     * @ORM\Column(name="TEAM_GOALSAGAINST", type="integer", nullable=true)
     */
    private $teamGoalsagainst = '0';

    /**
     * @var integer
     *
     * @ORM\Column(name="TEAM_POINTS", type="integer", nullable=true)
     */
    private $teamPoints = '0';

    /**
     * @var integer
     *
     * @ORM\Column(name="TEAM_POSITION", type="integer", nullable=true)
     */
    private $teamPosition = '0';

    /**
     * @var string
     *
     * @ORM\Column(name="TEAM_GROUP", type="string", length=1, nullable=true)
     */
    private $teamGroup;

    /**
     * @var string
     *
     * @ORM\Column(name="TEAM_CONTINENT", type="string", length=45, nullable=true)
     */
    private $teamContinent;

    /**
     * @var string
     *
     * @ORM\Column(name="TEAM_LOGO", type="string", length=500, nullable=true)
     */
    private $teamLogo;

    /**
     * @var string
     *
     * @ORM\Column(name="TEAM_FLAG", type="string", length=500, nullable=true)
     */
    private $teamFlag;

    /**
     * @var integer
     *
     * @ORM\Column(name="TEAM_ID", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $teamId;

    /**
     * @return string
     */
    public function getTeamName()
    {
        return $this->teamName;
    }

    /**
     * @param string $teamName
     */
    public function setTeamName($teamName)
    {
        $this->teamName = $teamName;
    }

    /**
     * @return string
     */
    public function getTeamCoach()
    {
        return $this->teamCoach;
    }

    /**
     * @param string $teamCoach
     */
    public function setTeamCoach($teamCoach)
    {
        $this->teamCoach = $teamCoach;
    }

    /**
     * @return int
     */
    public function getTeamIntmatchplayed()
    {
        return $this->teamIntmatchplayed;
    }

    /**
     * @param int $teamIntmatchplayed
     */
    public function setTeamIntmatchplayed($teamIntmatchplayed)
    {
        $this->teamIntmatchplayed = $teamIntmatchplayed;
    }

    /**
     * @return int
     */
    public function getTeamIntmatchwon()
    {
        return $this->teamIntmatchwon;
    }

    /**
     * @param int $teamIntmatchwon
     */
    public function setTeamIntmatchwon($teamIntmatchwon)
    {
        $this->teamIntmatchwon = $teamIntmatchwon;
    }

    /**
     * @return int
     */
    public function getTeamIntmatchlost()
    {
        return $this->teamIntmatchlost;
    }

    /**
     * @param int $teamIntmatchlost
     */
    public function setTeamIntmatchlost($teamIntmatchlost)
    {
        $this->teamIntmatchlost = $teamIntmatchlost;
    }

    /**
     * @return int
     */
    public function getTeamIntmatchdraw()
    {
        return $this->teamIntmatchdraw;
    }

    /**
     * @param int $teamIntmatchdraw
     */
    public function setTeamIntmatchdraw($teamIntmatchdraw)
    {
        $this->teamIntmatchdraw = $teamIntmatchdraw;
    }

    /**
     * @return int
     */
    public function getTeamGoalsfor()
    {
        return $this->teamGoalsfor;
    }

    /**
     * @param int $teamGoalsfor
     */
    public function setTeamGoalsfor($teamGoalsfor)
    {
        $this->teamGoalsfor = $teamGoalsfor;
    }

    /**
     * @return int
     */
    public function getTeamGoalsagainst()
    {
        return $this->teamGoalsagainst;
    }

    /**
     * @param int $teamGoalsagainst
     */
    public function setTeamGoalsagainst($teamGoalsagainst)
    {
        $this->teamGoalsagainst = $teamGoalsagainst;
    }

    /**
     * @return int
     */
    public function getTeamPoints()
    {
        return $this->teamPoints;
    }

    /**
     * @param int $teamPoints
     */
    public function setTeamPoints($teamPoints)
    {
        $this->teamPoints = $teamPoints;
    }

    /**
     * @return int
     */
    public function getTeamPosition()
    {
        return $this->teamPosition;
    }

    /**
     * @param int $teamPosition
     */
    public function setTeamPosition($teamPosition)
    {
        $this->teamPosition = $teamPosition;
    }

    /**
     * @return string
     */
    public function getTeamGroup()
    {
        return $this->teamGroup;
    }

    /**
     * @param string $teamGroup
     */
    public function setTeamGroup($teamGroup)
    {
        $this->teamGroup = $teamGroup;
    }

    /**
     * @return string
     */
    public function getTeamContinent()
    {
        return $this->teamContinent;
    }

    /**
     * @param string $teamContinent
     */
    public function setTeamContinent($teamContinent)
    {
        $this->teamContinent = $teamContinent;
    }

    /**
     * @return string
     */
    public function getTeamLogo()
    {
        return $this->teamLogo;
    }

    /**
     * @param string $teamLogo
     */
    public function setTeamLogo($teamLogo)
    {
        $this->teamLogo = $teamLogo;
    }

    /**
     * @return string
     */
    public function getTeamFlag()
    {
        return $this->teamFlag;
    }

    /**
     * @param string $teamFlag
     */
    public function setTeamFlag($teamFlag)
    {
        $this->teamFlag = $teamFlag;
    }

    /**
     * @return int
     */
    public function getTeamId()
    {
        return $this->teamId;
    }

    /**
     * @param int $teamId
     */
    public function setTeamId($teamId)
    {
        $this->teamId = $teamId;
    }





    /**
     * Set game
     *
     * @param \GameFrontBundle\Entity\Game $game
     *
     * @return Team
     */
    public function setGame(\GameFrontBundle\Entity\Game $game = null)
    {
        $this->game = $game;

        return $this;
    }

    /**
     * Get game
     *
     * @return \GameFrontBundle\Entity\Game
     */
    public function getGame()
    {
        return $this->game;
    }
}

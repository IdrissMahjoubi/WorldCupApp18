<?php

namespace GameFrontBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Game
 *
 * @ORM\Table(name="GAME")
 * @ORM\Entity
 */
class Game
{
    /**
     * @var string
     *
     * @ORM\Column(name="GAME_KIND", type="string", length=40, nullable=false)
     */
    private $gameKind;

    /**
     * @var string
     *
     * @ORM\Column(name="GAME_WINNERTEAM", type="string", length=45, nullable=false)
     */
    private $gameWinnerteam;

    /**
     * @var string
     *
     * @ORM\Column(name="GAME_LOSSTEAM", type="string", length=45, nullable=false)
     */
    private $gameLossteam;

    /**
     * @var string
     *
     * @ORM\Column(name="GAME_TIME", type="string", length=45, nullable=false)
     */
    private $gameTime;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="GAME_DATE", type="date", nullable=false)
     */
    private $gameDate;

    /**
     * @var integer
     *
     * @ORM\Column(name="GAME_WINNERTEAMSCORE", type="integer", nullable=false)
     */
    private $gameWinnerteamscore;

    /**
     * @var integer
     *
     * @ORM\Column(name="GAME_LOSSTEAMSCORE", type="integer", nullable=false)
     */
    private $gameLossteamscore;

    /**
     * @var string
     *
     * @ORM\Column(name="GAME_REFEREE", type="string", length=50, nullable=false)
     */
    private $gameReferee = 'UNKNOWN';

    /**
     * @var string
     *
     * @ORM\Column(name="GAME_STADIUM", type="string", length=40, nullable=false)
     */
    private $gameStadium;

    /**
     * @var string
     *
     * @ORM\Column(name="GAME_VENUE", type="string", length=40, nullable=false)
     */
    private $gameVenue;

    /**
     * @var integer
     *
     * @ORM\Column(name="GAME_MATCHNUMBER", type="integer", nullable=true)
     */
    private $gameMatchnumber;

    /**
     * @var integer
     *
     * @ORM\Column(name="GAME_ID", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $gameId;

    /**
     * @return \DateTime
     */
    public function getGameDate()
    {
        return $this->gameDate;
    }

    /**
     * @param \DateTime $gameDate
     */
    public function setGameDate($gameDate)
    {
        $this->gameDate = $gameDate;
    }

    /**
     * @return string
     */
    public function getGameKind()
    {
        return $this->gameKind;
    }

    /**
     * @param string $gameKind
     */
    public function setGameKind($gameKind)
    {
        $this->gameKind = $gameKind;
    }

    /**
     * @return string
     */
    public function getGameWinnerteam()
    {
        return $this->gameWinnerteam;
    }

    /**
     * @param string $gameWinnerteam
     */
    public function setGameWinnerteam($gameWinnerteam)
    {
        $this->gameWinnerteam = $gameWinnerteam;
    }

    /**
     * @return string
     */
    public function getGameLossteam()
    {
        return $this->gameLossteam;
    }

    /**
     * @param string $gameLossteam
     */
    public function setGameLossteam($gameLossteam)
    {
        $this->gameLossteam = $gameLossteam;
    }

    /**
     * @return string
     */
    public function getGameTime()
    {
        return $this->gameTime;
    }

    /**
     * @param string $gameTime
     */
    public function setGameTime($gameTime)
    {
        $this->gameTime = $gameTime;
    }

    /**
     * @return int
     */
    public function getGameWinnerteamscore()
    {
        return $this->gameWinnerteamscore;
    }

    /**
     * @param int $gameWinnerteamscore
     */
    public function setGameWinnerteamscore($gameWinnerteamscore)
    {
        $this->gameWinnerteamscore = $gameWinnerteamscore;
    }

    /**
     * @return int
     */
    public function getGameLossteamscore()
    {
        return $this->gameLossteamscore;
    }

    /**
     * @param int $gameLossteamscore
     */
    public function setGameLossteamscore($gameLossteamscore)
    {
        $this->gameLossteamscore = $gameLossteamscore;
    }

    /**
     * @return string
     */
    public function getGameReferee()
    {
        return $this->gameReferee;
    }

    /**
     * @param string $gameReferee
     */
    public function setGameReferee($gameReferee)
    {
        $this->gameReferee = $gameReferee;
    }

    /**
     * @return string
     */
    public function getGameStadium()
    {
        return $this->gameStadium;
    }

    /**
     * @param string $gameStadium
     */
    public function setGameStadium($gameStadium)
    {
        $this->gameStadium = $gameStadium;
    }

    /**
     * @return string
     */
    public function getGameVenue()
    {
        return $this->gameVenue;
    }

    /**
     * @param string $gameVenue
     */
    public function setGameVenue($gameVenue)
    {
        $this->gameVenue = $gameVenue;
    }

    /**
     * @return int
     */
    public function getGameMatchnumber()
    {
        return $this->gameMatchnumber;
    }

    /**
     * @param int $gameMatchnumber
     */
    public function setGameMatchnumber($gameMatchnumber)
    {
        $this->gameMatchnumber = $gameMatchnumber;
    }

    /**
     * @return int
     */
    public function getGameId()
    {
        return $this->gameId;
    }

    /**
     * @param int $gameId
     */
    public function setGameId($gameId)
    {
        $this->gameId = $gameId;
    }



}

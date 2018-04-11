<?php

namespace GameFrontBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class TeamType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('teamName')->add('teamCoach')->add('teamIntmatchplayed')->add('teamIntmatchwon')->add('teamIntmatchlost')->add('teamIntmatchdraw')->add('teamGoalsfor')->add('teamGoalsagainst')->add('teamPoints')->add('teamPosition')->add('teamGroup')->add('teamContinent')->add('teamLogo')->add('teamFlag');
    }/**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'GameFrontBundle\Entity\Team'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'gamefrontbundle_team';
    }


}

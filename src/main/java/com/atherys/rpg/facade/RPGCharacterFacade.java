package com.atherys.rpg.facade;

import com.atherys.rpg.service.DamageService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.spongepowered.api.event.entity.DamageEntityEvent;

@Singleton
public class RPGCharacterFacade {

    @Inject
    private DamageService damageService;

    public void onDamage(DamageEntityEvent event) {

    }

}

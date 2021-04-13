package com.atherys.rpg.skill.description;

import com.atherys.rpg.AtherysRPG;
import com.atherys.rpg.api.skill.DescriptionArgument;
import com.atherys.rpg.api.skill.RPGSkill;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;

public class PropertyDescriptionArgument implements DescriptionArgument {
    protected RPGSkill skill;
    protected String propertyName;
    protected String defaultValue;

    public PropertyDescriptionArgument(RPGSkill skill, String propertyName, String defaultValue) {
        this.skill = skill;
        this.propertyName = propertyName;
        this.defaultValue = defaultValue;
    }

    @Override
    public TextRepresentable apply(Living living) {
        String expression = skill.getProperty(propertyName, String.class, defaultValue);
        double value = AtherysRPG.getInstance().getExpressionService().evalExpression(living, expression).doubleValue();
        return Text.of(String.format("%.2f", value));
    }

    public long asLong(Living living) {
        String expression = skill.getProperty(propertyName, String.class, defaultValue);
        return AtherysRPG.getInstance().getExpressionService().evalExpression(living, expression).longValue();
    }
}

package com.anton_belaid.hs_like.utils;

import com.anton_belaid.hs_like.model.Champion;
import com.anton_belaid.hs_like.model.ClassicMonster;
import com.anton_belaid.hs_like.model.HealerMonster;
import com.anton_belaid.hs_like.model.MascottMonster;
import com.anton_belaid.hs_like.model.SpecialAbility;
import com.anton_belaid.hs_like.model.Card;
import com.anton_belaid.hs_like.model.ProtectorMonster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ChampionSelector {
    private static final Random RANDOM = new Random();
    private static final List<Champion> CHAMPIONS = new ArrayList<>(Arrays.asList(
            new Champion("C1", "Gideon the Soulbound", 10, new SpecialAbility("Spectral Surge", "Channels ethereal energy to unleash a devastating surge of spectral power.", 2), Arrays.asList(
            new Card("c1", "Necronomicon", new ClassicMonster("m1", "Cthulhu", 1, 8)),
            new Card("c2", "Bloodmoon Ritual", new ProtectorMonster("m2", "Lilith", 3, 4)),
            new Card("c3", "Soul Eater", new HealerMonster("m3", "Azazel", 6, 10)),
            new Card("c4", "Eternal Darkness", new MascottMonster("m4", "Mortis", 10, 6)),
            new Card("c5", "Shadowfang", new ClassicMonster("m5", "Ravenna", 4, 3)),
            new Card("c6", "Nightmare's Grasp", new ProtectorMonster("m6", "Lucifer", 8, 1))
        )),
        new Champion("C2", "Helvene the Nightshade", 12, new SpecialAbility("Shadow Veil", "Cloaks herself in shadows, becoming invisible to enemies for a short duration.", 1), Arrays.asList(
            new Card("c7", "Spectral Vengeance", new ClassicMonster("m7", "Morana", 1, 8)),
            new Card("c8", "Bane of Shadows", new ProtectorMonster("m8", "Vladimir", 3, 4)),
            new Card("c9", "Cursed Relic", new HealerMonster("m9", "Belhema", 6, 10)),
            new Card("c10", "Eclipse of Souls", new MascottMonster("m10", "Draven", 10, 6)),
            new Card("c11", "Cryptic Whispers", new ClassicMonster("m11", "Isabella", 4, 3)),
            new Card("c12", "Dreadfang Serpent", new ProtectorMonster("m12", "Sylvanus", 8, 1))
        )),
        new Champion("C3", "Ezekiel the Undying", 11, new SpecialAbility("Necrotic Embrace", "Embraces the power of undeath, fortifying himself and draining life from nearby enemies.", 1), Arrays.asList(
            new Card("c13", "Eternal Torment", new ClassicMonster("m13", "Sanguina", 1, 8)),
            new Card("c14", "Nightshade Coven", new ProtectorMonster("m14", "Malachi", 3, 4)),
            new Card("c15", "Moonlit Masquerade", new HealerMonster("m15", "Luna", 6, 10)),
            new Card("c16", "Soulstealer's Embrace", new MascottMonster("m16", "Astaroth", 10, 6)),
            new Card("c17", "Graveheart Sentinel", new ClassicMonster("m17", "Mortessa", 4, 3)),
            new Card("c18", "Crimson Revenant", new ProtectorMonster("m18", "Damien", 8, 1))
        )),
        new Champion("C4", "Ma'Ahloth the Deathbringer", 13, new SpecialAbility("Dreadstorm", "Summons a swirling vortex of dark energy, tearing through enemies with unstoppable force.", 1), Arrays.asList(           
            new Card("c19", "Shadowbane", new ClassicMonster("m19", "Lorelei", 1, 8)),
            new Card("c20", "Doombringer", new ProtectorMonster("m20", "Thanatos", 3, 4)),
            new Card("c21", "Cursed Moonlight", new HealerMonster("m21", "Lycan", 6, 10)),
            new Card("c22", "Soulreaper's Call", new MascottMonster("m22", "Nephilim", 10, 6)),
            new Card("c23", "Eldritch Conjurer", new ClassicMonster("m23", "Morgana", 4, 3)),
            new Card("c24", "Bloodthorn Specter", new ProtectorMonster("m24", "Vespera", 8, 1))
        ))
    ));

    public static Champion selectRandomChampion() {
        int randomIndex = RANDOM.nextInt(CHAMPIONS.size());
        Champion selectedChampion = CHAMPIONS.get(randomIndex);
        CHAMPIONS.remove(randomIndex); // remove the selected champion from the list
        return selectedChampion;
    }
}
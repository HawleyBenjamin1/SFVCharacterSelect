package characters;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Character {
    private String name;
    private boolean threeFrame;
    private int health;
    private int stun;
    private Speed walkSpeed;
    private Damage damage;
    private Meter meterUse;
    private boolean goodTrigger;
    private boolean lePlusFrames;
    private Range range;
    private Cheap cheap;
    private Tier tier;

    public Character(String line) {
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter(",");

        setName(lineScanner.next());
        setHealth(lineScanner.nextInt());
        setStun(lineScanner.nextInt());
        setThreeFrame(lineScanner.nextBoolean());
        setWalkSpeed(Speed.valueOf(lineScanner.next()));
        setDamage(Damage.valueOf(lineScanner.next()));
        setMeterUse(Meter.valueOf(lineScanner.next()));
        setGoodTrigger(lineScanner.nextBoolean());
        setLePlusFrames(lineScanner.nextBoolean());
        setRange(Range.valueOf(lineScanner.next()));
        setCheap(Cheap.valueOf(lineScanner.next()));
        setTier(Tier.valueOf(lineScanner.next()));
    }

    public boolean getGoodTrigger() {
        return goodTrigger;
    }

    public boolean getLePlusFrames() {
        return lePlusFrames;
    }
}

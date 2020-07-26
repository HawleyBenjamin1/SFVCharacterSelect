import characters.*;

import java.io.*;
import characters.Character;
import java.util.ArrayList;
import java.util.Scanner;

// TODO: Rework filter so that you don't have to filter by a category and the list will return everything.
// TODO: Fill in the rest of the requests.
// TODO: Print results of list request to console.
public class Selector {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Tier (LOW, MID, TOP): ");
        Tier.valueOf(inputScanner.next());
        System.out.println("Range (LOW, MID, HIGH): ");
        Range.valueOf(inputScanner.next());
        System.out.println("Cheap (NO, YES, MAD, STOPIT): ");
        Cheap.valueOf(inputScanner.next());

    }

    private ArrayList<Character> CreateList(Speed walkSpeed, Damage damage, Meter meter,
                                            boolean goodTrigger, boolean lePlusFrames,
                                            Range range, Cheap cheap, Tier tier) throws IOException {

        File characterList = new File("resources/CharacterList.csv");
        BufferedReader br = new BufferedReader(new FileReader(characterList));

        ArrayList<Character> desiredCharacters = new ArrayList<Character>();
        br.lines().forEach((line -> {
            desiredCharacters.add(new Character(line));
        }));

        for (Character c : desiredCharacters) {
            if (!c.getWalkSpeed().equals(walkSpeed))
                desiredCharacters.remove(c);
            if (!c.getDamage().equals(damage))
                desiredCharacters.remove(c);
            if (!c.getMeterUse().equals(meter))
                desiredCharacters.remove(c);
            if (c.getGoodTrigger() != goodTrigger)
                desiredCharacters.remove(c);
            if (c.getLePlusFrames() != lePlusFrames)
                desiredCharacters.remove(c);
            if (!c.getRange().equals(range))
                desiredCharacters.remove(c);
            if (!c.getCheap().equals(cheap))
                desiredCharacters.remove(c);
            if (!c.getTier().equals(tier))
                desiredCharacters.remove(c);
        }

        return desiredCharacters;
    }
}

package agh.ics.oop;

import javax.swing.text.Position;
import java.util.Objects;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private final int grassNumber;
    private final int grassMaxSpawn;

    public GrassField(int grassNumber, Vector2d[] positions) {
        this.grassNumber = grassNumber;
        this.grassMaxSpawn = (int) Math.sqrt(10 * this.grassNumber);
        Random random = new Random();

        //elements.put(new Vector2d(3,3), new Grass(new Vector2d(3,3)));
        //this.mapBonduary.update(new Vector2d(3,3));

        int i=0;
        while (i < this.grassNumber) {
            int x = random.nextInt(this.grassMaxSpawn);
            int y = random.nextInt(this.grassMaxSpawn);

            boolean flag = false;
            for (Vector2d position: positions) {
                if (Objects.equals(position, new Vector2d(x, y))) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                elements.put(new Vector2d(x, y), new Grass(new Vector2d(x, y)));
                mapBonduary.update(new Vector2d(x, y));
                i++;
            }
        }
    }

    public void RespawnGrass(Vector2d position) {
        elements.remove(position);
        mapBonduary.remove(position);
        int[][] epsilon = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1,-1}, {1, 0}, {1, 1}};
        for (int[] e: epsilon) {
            Vector2d newPosition = position.add(new Vector2d(e[0], e[1]));
            if (!(isOccupied(newPosition))) {
                System.out.println("Respawned grass at " + newPosition);
                elements.put(newPosition, new Grass(newPosition));
                mapBonduary.update(newPosition);
                break;
            }
        }
    }
}

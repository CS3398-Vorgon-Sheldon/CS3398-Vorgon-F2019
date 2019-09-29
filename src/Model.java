import java.awt.*;
import java.io.IOException;

public class Model {

    private Player player;

    Model()throws IOException {
        player = new Player();
    }

    public void update(Graphics g){
        player.update();
    }
}

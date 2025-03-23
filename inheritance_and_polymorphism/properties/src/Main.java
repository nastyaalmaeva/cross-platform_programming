import properties.*;

import java.util.ArrayList;
import ui.UserInteraction;

public class Main {
    public static void main(String[] args) {
        ArrayList<Property> properties = new ArrayList<Property>();
        UserInteraction ui = new UserInteraction(properties);

        while (true) ui.inputMainChoice();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class RateGamePanel extends MenuFundament {
    private JTextArea reviewArea;

    public RateGamePanel(ActionListener actionListener) {
        super();
        add(backToMenuBut);

        backToMenuBut.addActionListener(actionListener);

        reviewArea = new JTextArea(10, 30);
        reviewArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reviewArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void displayRatings(List<Rating> ratings) {
        reviewArea.setText("");
        for (Rating rating : ratings) {
            reviewArea.append("Username: " + rating.getUsername() + "\n");
            reviewArea.append("Rating: " + rating.getRating() + "\n");
            reviewArea.append("Comments: " + rating.getComment() + "\n");
            reviewArea.append("Timestamp: " + rating.getTimestamp() + "\n");
            reviewArea.append("------------------------\n");
        }
    }
}

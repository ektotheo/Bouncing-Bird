import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RateGamePanel extends MenuFundament {
    private JButton submitButton;
    private JTextArea reviewArea;
    private JTextField usernameField;
    private JTextField commentField;
    private JSpinner ratingSpinner;

    public RateGamePanel(ActionListener actionListener) {
        super();
        add(backToMenuBut);

        backToMenuBut.addActionListener(actionListener);

        // Create and add the review submission components
        usernameField = new JTextField(20);
        add(new JLabel("Username:"));
        add(usernameField);

        commentField = new JTextField(20);
        add(new JLabel("Comment:"));
        add(commentField);

        ratingSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
        add(new JLabel("Rating:"));
        add(ratingSpinner);

        submitButton = new JButton("Submit Review");
        add(submitButton);

        // Create and add the review display area
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
            reviewArea.append("Comment: " + rating.getComment() + "\n");
            reviewArea.append("Timestamp: " + rating.getTimestamp() + "\n");
            reviewArea.append("------------------------\n");
        }
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getComment() {
        return commentField.getText();
    }

    public int getRating() {
        return (Integer) ratingSpinner.getValue();
    }
}

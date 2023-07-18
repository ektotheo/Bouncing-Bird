import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RateGamePanel extends MenuFundament {
    private JButton submitButton;
    private JTextArea reviewArea;
    private JTextField usernameField;
    private JTextField commentField;
    private RateGameList rateGameList; // Assuming this is the class that has the addRating method

    public RateGamePanel(ActionListener actionListener, RateGameList rateGameList) {
        super();
        this.rateGameList = rateGameList;
        add(backToMenuBut);

        backToMenuBut.addActionListener(actionListener);

        initComponents();
        layoutComponents();
    }

    private void initComponents() {
        usernameField = new JTextField(20);
        add(new JLabel("Username:"));
        add(usernameField);

        commentField = new JTextField(20);
        add(new JLabel("Comment:"));
        add(commentField);

        submitButton = new JButton("Submit Review");
        submitButton.addActionListener(new ReviewSubmissionListener());
        add(submitButton);

        reviewArea = new JTextArea(10, 30);
        reviewArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reviewArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void displayRatings( ratings) {
        reviewArea.setText("");
        for (Rating rating : ratings) {
            reviewArea.append("Username: " + rating.getUsername() + "\n");
            reviewArea.append("Rating: " + rating.getRating() + "\n");
            reviewArea.append("Comment: " + rating.getComment() + "\n");
            reviewArea.append("Timestamp: " + rating.getTimestamp() + "\n");
            reviewArea.append("------------------------\n");
        }
    }

    private class ReviewSubmissionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String username = getUsername();
            String comment = getComment();

            if (username.isEmpty() || comment.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username and comment cannot be empty!");
                return;
            }

            // Assuming the addRating method takes a Rating object as parameter
            rateGameList.addRating(new Rating(username, comment, 5)); // Assuming a default rating of 5

            // Refresh the displayed ratings
            displayRatings(rateGameList.getRatings());
        }
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getComment() {
        return commentField.getText();
    }
}

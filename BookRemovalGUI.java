import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookRemovalGUI {
    // Empty list of books
    private static ArrayList<String> books = new ArrayList<>();

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Book Removal by Index");
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Label for instruction
        JLabel label = new JLabel("Enter the index of the book you want to remove:");
        label.setBounds(20, 20, 250, 25);
        frame.add(label);

        // Text field for user input
        JTextField indexField = new JTextField();
        indexField.setBounds(270, 20, 50, 25);
        frame.add(indexField);

        // Button to trigger the removal
        JButton removeButton = new JButton("Remove");
        removeButton.setBounds(150, 60, 100, 25);
        frame.add(removeButton);

        // Label to display the result
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(20, 100, 350, 25);
        frame.add(resultLabel);

        // ActionListener for the button
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the index from the text field
                    int index = Integer.parseInt(indexField.getText());

                    // Remove the book
                    String result = removeBookByIndex(books, index);

                    // Display the result
                    resultLabel.setText(result);
                } catch (NumberFormatException ex) {
                    // Handle invalid input
                    resultLabel.setText("Please enter a valid number.");
                }
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    // Method to remove a book by index
    public static String removeBookByIndex(ArrayList<String> books, int index) {
        if (books.isEmpty()) {
            return "No books in the list.";
        } else if (index >= 0 && index < books.size()) {
            String removedBook = books.remove(index);
            return "Removed: " + removedBook;
        } else {
            return "Index out of bounds";
        }
    }
}
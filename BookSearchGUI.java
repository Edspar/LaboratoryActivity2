package labExercise2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BookSearchGUI {
	    // Array of books
	    private static String[] books = {"The Great Gatsby", "To Kill a Mockingbird", "1984", "Pride and Prejudice", "Moby Dick",};

	    public static void main(String[] args) {
	        // Create the frame
	        JFrame frame = new JFrame("Book Search by Index");
	        frame.setSize(400, 150);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLayout(null);

	        // Label for instruction
	        JLabel label = new JLabel("Enter the index of the book you want to find:");
	        label.setBounds(20, 20, 250, 25);
	        frame.add(label);

	        // Text field for user input
	        JTextField indexField = new JTextField();
	        indexField.setBounds(270, 20, 50, 25);
	        frame.add(indexField);

	        // Button to trigger the search
	        JButton searchButton = new JButton("Search");
	        searchButton.setBounds(150, 60, 100, 25);
	        frame.add(searchButton);

	        // Label to display the result
	        JLabel resultLabel = new JLabel("");
	        resultLabel.setBounds(20, 100, 350, 25);
	        frame.add(resultLabel);

	        // ActionListener for the button
	        searchButton.addActionListener(new ActionListener() {
	            public void actionPerformed1(ActionEvent e) {
	                try {
	                    // Get the index from the text field
	                    int index = Integer.parseInt(indexField.getText());

	                    // Search for the book
	                    String book = findBookByIndex(books, index);

	                    // Display the result
	                    resultLabel.setText("Book at index " + index + ": " + book);
	                } catch (NumberFormatException ex) {
	                    // Handle invalid input
	                    resultLabel.setText("Please enter a valid number.");
	                }
	            }

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
	        });

	        // Make the frame visible
	        frame.setVisible(true);
	    }

	    // Method to find a book by index
	    public static String findBookByIndex(String[] books, int index) {
	        if (index >= 0 && index < books.length) {
	            return books[index];
	        } else {
	            return "Index out of bounds";
	        }
	    }

}

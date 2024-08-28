package labExercise2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookManager {
    private JFrame frame;
    private JTextField bookNameField;
    private JTextField indexField;
    private JTextArea outputArea;
    private ArrayList<String> books;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BookManager window = new BookManager();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public BookManager() {
        books = new ArrayList<>();

        frame = new JFrame();
        frame.setResizable(false);
        frame.setAutoRequestFocus(false);
        frame.getContentPane().setBackground(new Color(165, 42, 42));
        frame.setBounds(100, 100, 740, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblBookName = new JLabel("Book Title: ");
        lblBookName.setForeground(new Color(255, 255, 255));
        lblBookName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblBookName.setBounds(30, 44, 133, 92);
        frame.getContentPane().add(lblBookName);

        bookNameField = new JTextField();
        bookNameField.setBounds(20, 110, 363, 58);
        frame.getContentPane().add(bookNameField);
        bookNameField.setColumns(10);

        JLabel lblIndex = new JLabel("Search book by Index: ");
        lblIndex.setForeground(new Color(255, 255, 255));
        lblIndex.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblIndex.setBounds(30, 152, 224, 92);
        frame.getContentPane().add(lblIndex);

        indexField = new JTextField();
        indexField.setBounds(20, 218, 363, 58);
        frame.getContentPane().add(indexField);
        indexField.setColumns(10);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAdd.setBounds(280, 79, 103, 27);
        frame.getContentPane().add(btnAdd);

        JButton btnRemove = new JButton("Remove");
        btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnRemove.setBounds(518, 217, 120, 39);
        frame.getContentPane().add(btnRemove);

        JButton btnSearch = new JButton("Search Book");
        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSearch.setBounds(393, 218, 120, 38);
        frame.getContentPane().add(btnSearch);

        JButton btnDisplay = new JButton("Display Total Books");
        btnDisplay.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnDisplay.setBounds(410, 107, 170, 29);
        frame.getContentPane().add(btnDisplay);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 286, 685, 151);
        frame.getContentPane().add(scrollPane);
                
                        outputArea = new JTextArea();
                        scrollPane.setViewportView(outputArea);
                        outputArea.setEditable(false);
                        
                        JLabel lblNewLabel = new JLabel("Library Management System");
                        lblNewLabel.setForeground(new Color(255, 255, 255));
                        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
                        lblNewLabel.setBounds(163, 10, 685, 58);
                        frame.getContentPane().add(lblNewLabel);
                        
                        
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookName = bookNameField.getText();
                if (!bookName.isEmpty()) {
                    books.add(bookName);
                    outputArea.append("Added: " + bookName + "\n");
                    bookNameField.setText("");
                } else {
                    outputArea.append("Please enter a book name.\n");
                }
            }
        });

        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = Integer.parseInt(indexField.getText());
                    if (index >= 0 && index < books.size()) {
                        String removedBook = books.remove(index);
                        outputArea.append("Removed: " + removedBook + "\n");
                    } else {
                        outputArea.append("Index out of range.\n");
                    }
                } catch (NumberFormatException ex) {
                    outputArea.append("Invalid index format.\n");
                }
                indexField.setText("");
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = Integer.parseInt(indexField.getText());
                    if (index >= 0 && index < books.size()) {
                        String bookName = books.get(index);
                        outputArea.append("Book at index " + index + ": " + bookName + "\n");
                    } else {
                        outputArea.append("Index out of range.\n");
                    }
                } catch (NumberFormatException ex) {
                    outputArea.append("Invalid index format.\n");
                }
                indexField.setText("");
            }
        });
        
        JTextArea textAreaDisplay = new JTextArea();
        textAreaDisplay.setEditable(false);
        textAreaDisplay.setBounds(586, 97, 119, 54);
        frame.getContentPane().add(textAreaDisplay);


        btnDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaDisplay.append("Total Books: " + books.size() + "\n");
            }
        });
    }
}

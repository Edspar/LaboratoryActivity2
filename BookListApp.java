package labExercise2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookListApp {

    private JFrame frame;
    private JTextField textField;
    private JTextArea textArea;
    private ArrayList<String> bookList;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BookListApp window = new BookListApp();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public BookListApp() {
        bookList = new ArrayList<>();

        frame = new JFrame();
        frame.setResizable(false);
//        frame.setBounds(100, 100, 700, 400);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        JLabel lblEnterBookTitle = new JLabel("Enter Book Title:");
        lblEnterBookTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(lblEnterBookTitle);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
        panel.add(textField);
        textField.setColumns(20);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panel.add(btnAdd);
        
        JButton btnNewButton = new JButton("Confirm");
        	btnNewButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					AddbooksConfirmation confrim = new AddbooksConfirmation();
					confrim.setVisible(true);
					
				}
        		
        	});
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panel.add(btnNewButton);

        textArea = new JTextArea();
        textArea.setForeground(new Color(255, 255, 255));
        textArea.setBackground(new Color(165, 42, 42));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER); 

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookTitle = textField.getText().trim();
                if (!bookTitle.isEmpty()) {
                    bookList.add(bookTitle);
                    textField.setText("");
                    updateBookList();
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a book title.");
                }
            }
        });
    }

    private void updateBookList() {
        textArea.setText("");
        for (String title : bookList) {
            textArea.append(title + "\n");
        }
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

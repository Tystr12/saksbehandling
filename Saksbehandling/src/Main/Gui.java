package Main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Gui extends JFrame{
	
	static ArrayList<S�knad> s�knader = new ArrayList<>();
    static ArrayList<String> organisasjoner = new ArrayList<>(List.of("NAV", "Bufdir", "Forbrukertilsynet"));

    private JTextArea displayArea;

    public Gui() {
        setTitle("S�knad System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        
        JButton generateButton = new JButton("Generer S�knader");
        JButton printButton = new JButton("Skriv ut alle S�knader");

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genererS�knader();
                JOptionPane.showMessageDialog(null, "20 s�knader generert!");
            }
        });

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skrivUtAlle();
            }
        });

        buttonPanel.add(generateButton);
        buttonPanel.add(printButton);
        add(buttonPanel, BorderLayout.NORTH);

        
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void genererS�knader() {
        s�knader.clear();
        Random rand = new Random();
        
        for (int i = 0; i < 20; i++) {
            int type = rand.nextInt(2);
            int organisasjon = rand.nextInt(organisasjoner.size());
            if (type == 0) {
                s�knader.add(new S�knad("Test S�ker", organisasjoner.get(organisasjon)));
            } else {
                s�knader.add(new PengeS�knad("Test S�ker", organisasjoner.get(organisasjon)));
            }
        }
    }

    public void skrivUtAlle() {
        displayArea.setText("");  // Clear existing text

        displayArea.append("Penger s�knader:\n");
        displayArea.append("------------------------------------------------------------\n");
        s�knader.stream()
                .filter(s -> s.getS�knadsType().equals("PENGER"))
                .forEach(s -> displayArea.append(s.toString() + "\n"));

        displayArea.append("Tilatelse s�knader:\n");
        displayArea.append("------------------------------------------------------------\n");
        s�knader.stream()
                .filter(s -> s.getS�knadsType().equals("TILATELSE"))
                .forEach(s -> displayArea.append(s.toString() + "\n"));
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Gui frame = new Gui();
            frame.setVisible(true);
        });
    }

}

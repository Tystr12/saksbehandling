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
	
	static ArrayList<Søknad> søknader = new ArrayList<>();
    static ArrayList<String> organisasjoner = new ArrayList<>(List.of("NAV", "Bufdir", "Forbrukertilsynet"));

    private JTextArea displayArea;

    public Gui() {
        setTitle("Søknad System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        
        JButton generateButton = new JButton("Generer Søknader");
        JButton printButton = new JButton("Skriv ut alle Søknader");

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genererSøknader();
                JOptionPane.showMessageDialog(null, "20 søknader generert!");
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

    public static void genererSøknader() {
        søknader.clear();
        Random rand = new Random();
        
        for (int i = 0; i < 20; i++) {
            int type = rand.nextInt(2);
            int organisasjon = rand.nextInt(organisasjoner.size());
            if (type == 0) {
                søknader.add(new Søknad("Test Søker", organisasjoner.get(organisasjon)));
            } else {
                søknader.add(new PengeSøknad("Test Søker", organisasjoner.get(organisasjon)));
            }
        }
    }

    public void skrivUtAlle() {
        displayArea.setText("");  // Clear existing text

        displayArea.append("Penger søknader:\n");
        displayArea.append("------------------------------------------------------------\n");
        søknader.stream()
                .filter(s -> s.getSøknadsType().equals("PENGER"))
                .forEach(s -> displayArea.append(s.toString() + "\n"));

        displayArea.append("Tilatelse søknader:\n");
        displayArea.append("------------------------------------------------------------\n");
        søknader.stream()
                .filter(s -> s.getSøknadsType().equals("TILATELSE"))
                .forEach(s -> displayArea.append(s.toString() + "\n"));
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Gui frame = new Gui();
            frame.setVisible(true);
        });
    }

}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PeselGUI {
    private JPanel glowny;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel numerLabel;
    private JLabel imieLabel;
    private JLabel nazwiskoLabel;
    private JLabel kolorOczuLabel;
    private JRadioButton niebieskieRadioButton;
    private JRadioButton zieloneRadioButton;
    private JRadioButton piwneRadioButton;
    private JButton OKButton;

    public PeselGUI() {
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pesel numerPesel = new Pesel(numerLabel.getText());
            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pesel imie = new Pesel(imieLabel.getText());
                Pesel nazwisko = new Pesel(nazwiskoLabel.getText());
                Pesel niebieskieOczy = new Pesel(niebieskieRadioButton.getText());
                Pesel zieloneOczy = new Pesel(zieloneRadioButton.getText());
                Pesel piwneOczy = new Pesel(piwneRadioButton.getText());

                if (!imie.isEmpty() && !nazwisko.isEmpty()){
                    System.out.println(imie + nazwisko + "kolor oczu ");
                } else {
                    System.out.println("Wpowadz dane");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Wprowadzenie danych do paszportu. Wykonał: Mateusz Ostróżka");
        frame.setContentPane(new PeselGUI().glowny);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}

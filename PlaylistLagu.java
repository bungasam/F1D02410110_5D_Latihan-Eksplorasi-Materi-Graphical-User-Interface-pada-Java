import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlaylistLagu extends JFrame implements ActionListener {

    JLabel labelJudul, labelPenyanyi, labelGenre;
    JTextField fieldJudul, fieldPenyanyi;
    JComboBox<String> pilihanGenre;
    JButton tombolTambah;
    JTextArea areaPlaylist;

    public PlaylistLagu() {
        setTitle("Playlist Lagu");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Color cream = new Color(247, 241, 233);
        Color beige = new Color(226, 211, 193);
        Color cokelat = new Color(110, 78, 55);

        JLabel judulAplikasi = new JLabel(
            "Playlist Lagu Saya", JLabel.CENTER
        );
        judulAplikasi.setFont(
            new Font("SansSerif", Font.BOLD, 20)
        );
        judulAplikasi.setForeground(cokelat);

        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridLayout(3, 2, 8, 8));
        panelInput.setBackground(cream);

        labelJudul = new JLabel("Judul lagu");
        labelPenyanyi = new JLabel("Penyanyi");
        labelGenre = new JLabel("Genre");

        labelJudul.setForeground(cokelat);
        labelPenyanyi.setForeground(cokelat);
        labelGenre.setForeground(cokelat);

        fieldJudul = new JTextField();
        fieldPenyanyi = new JTextField();

        String[] daftarGenre = {
            "Pop", "K-Pop", "R&B", "Rock", "Jazz"
        };
        pilihanGenre = new JComboBox<>(daftarGenre);
        pilihanGenre.setBackground(beige);

        panelInput.add(labelJudul);
        panelInput.add(fieldJudul);
        panelInput.add(labelPenyanyi);
        panelInput.add(fieldPenyanyi);
        panelInput.add(labelGenre);
        panelInput.add(pilihanGenre);

        tombolTambah = new JButton("Tambah Lagu");
        tombolTambah.setBackground(cokelat);
        tombolTambah.setForeground(Color.WHITE);
        tombolTambah.addActionListener(this);

        JPanel panelTombol = new JPanel();
        panelTombol.setBackground(cream);
        panelTombol.add(tombolTambah);

        JLabel labelPlaylist = new JLabel("Daftar lagu");
        labelPlaylist.setForeground(cokelat);
        labelPlaylist.setFont(
            new Font("SansSerif", Font.BOLD, 15)
        );

        areaPlaylist = new JTextArea();
        areaPlaylist.setEditable(false);
        areaPlaylist.setBackground(Color.WHITE);
        areaPlaylist.setForeground(cokelat);
        areaPlaylist.setFont(
            new Font("SansSerif", Font.PLAIN, 13)
        );

        JPanel panelUtama = new JPanel();
        panelUtama.setLayout(new BorderLayout(10, 12));
        panelUtama.setBackground(cream);

        JPanel panelAtas = new JPanel();
        panelAtas.setLayout(new BorderLayout(5, 12));
        panelAtas.setBackground(cream);

        panelAtas.add(judulAplikasi, BorderLayout.NORTH);

        JPanel panelForm = new JPanel();
        panelForm.setLayout(new BorderLayout(5, 8));
        panelForm.setBackground(cream);
        panelForm.add(panelInput, BorderLayout.CENTER);
        panelForm.add(panelTombol, BorderLayout.SOUTH);

        panelAtas.add(panelForm, BorderLayout.CENTER);

        JPanel panelDaftar = new JPanel();
        panelDaftar.setLayout(new BorderLayout(5, 5));
        panelDaftar.setBackground(cream);
        panelDaftar.add(labelPlaylist, BorderLayout.NORTH);
        panelDaftar.add(
            new JScrollPane(areaPlaylist), BorderLayout.CENTER
        );

        panelUtama.add(panelAtas, BorderLayout.NORTH);
        panelUtama.add(panelDaftar, BorderLayout.CENTER);

        add(panelUtama);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String judul = fieldJudul.getText();
        String penyanyi = fieldPenyanyi.getText();
        String genre = pilihanGenre.getSelectedItem().toString();

        if (judul.isEmpty() || penyanyi.isEmpty()) {
            JOptionPane.showMessageDialog(
                this, "Isi judul lagu dan penyanyi dulu!"
            );
        } else {
            areaPlaylist.append(
                judul + " - " + penyanyi + " (" + genre + ")\n"
            );

            fieldJudul.setText("");
            fieldPenyanyi.setText("");
        }
    }

    public static void main(String[] args) {
        new PlaylistLagu();
    }
}

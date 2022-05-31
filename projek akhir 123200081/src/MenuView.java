import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuView extends JFrame{
    JButton btnLihat = new JButton("Lihat Siswa");
    JButton btnLihatKelas = new JButton("Lihat Kelas");

    public MenuView() {
        setTitle("Data Manajemen Siswa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(300,400);

        add(btnLihat);
        btnLihat.setBounds(60, 170, 150, 20);
        add(btnLihatKelas);
        btnLihatKelas.setBounds(60, 200, 150, 20);


    }
}

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class LihatView extends JFrame{
    JLabel lNama = new JLabel("Nama");
    JLabel lAlamat = new JLabel("Alamat");
    JLabel lTTL = new JLabel("TTL");
    JLabel lKelas = new JLabel("Kelas");
    JLabel lCari = new JLabel("Cari Nama");

    JTextField tfNama = new JTextField();
    JTextField tfAlamat = new JTextField();
    JTextField tfTTL = new JTextField();
    JTextField tfKelas = new JTextField();
    JTextField tfCari = new JTextField();

    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");

    JButton btnCari = new JButton("Cari");
    JButton btnReset = new JButton("Refresh");

    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Nama", "Alamat", "TTL", "Kelas"};

    public LihatView() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);

        setTitle("Data Siswa");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900,400);

        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);

        add(lNama);
        lNama.setBounds(510, 20, 90, 20);
        add(tfNama);
        tfNama.setBounds(510, 40, 120, 20);

        add(lAlamat);
        lAlamat.setBounds(510, 60, 90, 20);
        add(tfAlamat);
        tfAlamat.setBounds(510, 80, 120, 20);

        add(lTTL);
        lTTL.setBounds(510, 100, 90, 20);
        add(tfTTL);
        tfTTL.setBounds(510, 120, 120, 20);

        add(lKelas);
        lKelas.setBounds(510, 140, 90, 20);
        add(tfKelas);
        tfKelas.setBounds(510, 160, 120, 20);

        add(btnTambah);
        btnTambah.setBounds(510, 190, 90, 20);

        add(btnUpdate);
        btnUpdate.setBounds(510, 220, 90, 20);

        add(btnDelete);
        btnDelete.setBounds(510, 250, 90, 20);



        add(lCari);
        lCari.setBounds(710, 20, 90, 20);

        add(tfCari);
        tfCari.setBounds(710, 40, 90, 20);

        add(btnCari);
        btnCari.setBounds(710, 70, 90, 20);

        add(btnReset);
        btnReset.setBounds(710, 100, 90, 20);


    }

    public String getNama(){
        return tfNama.getText();
    }

    public String getAlamat(){
        return tfAlamat.getText();
    }

    public String getTTL(){
        return tfTTL.getText();
    }

    public String getKelas(){
        return tfKelas.getText();
    }

    public String getCariNama(){
        return tfCari.getText();
    }
}


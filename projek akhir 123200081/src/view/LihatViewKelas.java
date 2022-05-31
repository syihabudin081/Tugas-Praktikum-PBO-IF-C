package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class LihatViewKelas extends JFrame{
    JLabel lNama = new JLabel("Nama Kelas");
    JLabel lPengajar = new JLabel("Pengajar");
    JLabel lHari = new JLabel("Hari");
    JLabel lDurasi = new JLabel("Durasi");
    JLabel lCari = new JLabel("Cari Nama");

    JTextField tfNama = new JTextField();
    JTextField tfPengajar = new JTextField();
    JTextField tfHari = new JTextField();
    JTextField tfDurasi = new JTextField();
    JTextField tfCari = new JTextField();

    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnCari = new JButton("Cari");
    public JButton btnReset = new JButton("Refresh");
    public JButton btnDelete = new JButton("Delete");

    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object[] namaKolom = {"Nama", "Pengajar", "Hari", "Durasi"};

    public LihatViewKelas() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);

        setTitle("Data Kelas");
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

        add(lPengajar);
        lPengajar.setBounds(510, 60, 90, 20);
        add(tfPengajar);
        tfPengajar.setBounds(510, 80, 120, 20);

        add(lHari);
        lHari.setBounds(510, 100, 90, 20);
        add(tfHari);
        tfHari.setBounds(510, 120, 120, 20);

        add(lDurasi);
        lDurasi.setBounds(510, 140, 90, 20);
        add(tfDurasi);
        tfDurasi.setBounds(510, 160, 120, 20);

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

    public String getPengajar(){
        return tfPengajar.getText();
    }

    public String getHari(){
        return tfHari.getText();
    }

    public String getDurasi(){
        return tfDurasi.getText();
    }

    public String getCariNama(){
        return tfCari.getText();
    }
}


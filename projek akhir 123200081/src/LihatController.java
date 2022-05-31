import view.LihatViewKelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class LihatController {

    LihatModel lihatModell;
    LihatView lihatVieww;
    LihatViewKelas lihatviewkelas;
    public String dataterpilih;

    public LihatController(LihatView lihatView, LihatModel lihatModel) {
        this.lihatModell = lihatModel;
        this.lihatVieww = lihatView;

        if (lihatModell.getBanyakData() != 0) {
            String datasiswa[][] = lihatModell.readsiswa();
            lihatVieww.tabel.setModel((new JTable(datasiswa, lihatVieww.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        lihatVieww.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nama = lihatVieww.getNama();
                String Alamat = lihatVieww.getAlamat();
                String TTL = lihatVieww.getTTL();
                String Kelas = lihatVieww.getKelas();
                lihatModell.insertData(Nama, Alamat, TTL, Kelas);

                String datasiswa[][] = lihatModell.readsiswa();
                lihatVieww.tabel.setModel((new JTable(datasiswa, lihatVieww.namaKolom)).getModel());
            }
        });

        lihatVieww.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nama = lihatVieww.getNama();
                String Alamat = lihatVieww.getAlamat();
                String TTL = lihatVieww.getTTL();
                String Kelas = lihatVieww.getKelas();
                lihatModell.updatesiswa(Nama, Alamat, TTL, Kelas);

                String datasiswa[][] = lihatModell.readsiswa();
                lihatVieww.tabel.setModel((new JTable(datasiswa, lihatVieww.namaKolom)).getModel());
            }
        });

        lihatVieww.btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nama = lihatVieww.getCariNama();

                if (Nama.equals("")) {
                    JOptionPane.showMessageDialog(null, "Data Kosong");
                } else {
                    String datasiswa[][] = lihatModell.carisiswa(Nama);
                    lihatVieww.tabel.setModel((new JTable(datasiswa, lihatVieww.namaKolom)).getModel());
                }

            }
        });

        lihatVieww.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String datasiswa[][] = lihatModell.readsiswa();
                lihatVieww.tabel.setModel((new JTable(datasiswa, lihatVieww.namaKolom)).getModel());
            }
        });


        lihatVieww.tabel.addMouseListener(new MouseAdapter() {
                                              @Override
                                              public void mouseClicked(MouseEvent e) {
                                                  super.mousePressed(e);
                                                  int baris = lihatVieww.tabel.getSelectedRow();


                                                  dataterpilih = lihatVieww.tabel.getValueAt(baris, 0).toString();

                                                  System.out.println(dataterpilih);


                                              }
                                          }

        );


        lihatVieww.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int input = JOptionPane.showConfirmDialog(null, "Apa anda ingin menghapus Data Siswa " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    lihatModell.deletesiswa(dataterpilih);
                    String datasiswa[][] = lihatModell.readsiswa();
                    lihatVieww.tabel.setModel((new JTable(datasiswa, lihatVieww.namaKolom)).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });


    }

    public LihatController(LihatViewKelas lihatView, LihatModel lihatModel) {
        this.lihatviewkelas = lihatView;
        this.lihatModell = lihatModel;

        if (lihatModell.getBanyakDataKelas() != 0) {
            String datakelas[][] = lihatModell.readkelas();
            lihatviewkelas.tabel.setModel((new JTable(datakelas, lihatviewkelas.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        lihatviewkelas.btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nama = lihatviewkelas.getCariNama();

                if (Nama.equals("")) {
                    JOptionPane.showMessageDialog(null, "Data Kosong");
                } else {
                    String datakelas[][] = lihatModell.carikelas(Nama);

                    lihatviewkelas.tabel.setModel((new JTable(datakelas, lihatviewkelas.namaKolom)).getModel());
                }

            }
        });

        lihatviewkelas.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nama = lihatviewkelas.getNama();
                String Pengajar = lihatviewkelas.getPengajar();
                String Hari = lihatviewkelas.getHari();
                String Durasi = lihatviewkelas.getDurasi();
                lihatModell.insertDataKelas(Nama, Pengajar, Hari, Durasi);

                String datakelas[][] = lihatModell.readkelas();
                lihatviewkelas.tabel.setModel((new JTable(datakelas, lihatviewkelas.namaKolom)).getModel());
            }
        });

        lihatviewkelas.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nama = lihatviewkelas.getNama();
                String Pengajar = lihatviewkelas.getPengajar();
                String Hari = lihatviewkelas.getHari();
                String Durasi = lihatviewkelas.getDurasi();
                lihatModell.updateDataKelas(Nama, Pengajar, Hari, Durasi);


                String datakelas[][] = lihatModell.readkelas();
                lihatviewkelas.tabel.setModel((new JTable(datakelas, lihatviewkelas.namaKolom)).getModel());
            }
        });


        lihatviewkelas.btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nama = lihatviewkelas.getCariNama();

                if (Nama.equals("")) {
                    JOptionPane.showMessageDialog(null, "Data Kosong");
                } else {
                    String datakelas[][] = lihatModell.carikelas(Nama);
                    lihatviewkelas.tabel.setModel((new JTable(datakelas, lihatviewkelas.namaKolom)).getModel());
                }

            }
        });

        lihatviewkelas.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String datakelas[][] = lihatModell.readkelas();
                lihatviewkelas.tabel.setModel((new JTable(datakelas, lihatviewkelas.namaKolom)).getModel());
            }
        });


        lihatviewkelas.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = lihatviewkelas.tabel.getSelectedRow();

                dataterpilih = lihatviewkelas.tabel.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);


                                              }
                                          }

        );


        lihatviewkelas.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int input = JOptionPane.showConfirmDialog(null, "Apa anda ingin menghapus Kelas " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    lihatModell.deletekelas(dataterpilih);
                    String datakelas[][] = lihatModell.readkelas();
                    lihatviewkelas.tabel.setModel((new JTable(datakelas, lihatviewkelas.namaKolom)).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });

    }
}

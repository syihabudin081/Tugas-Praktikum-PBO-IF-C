import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class LihatModel {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbsiswa";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    public LihatModel(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public String[][] readsiswa(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][4]; //baris, kolom nya ada 4

            String query = "Select * from siswa";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nama"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("alamat");
                data[jmlData][2] = resultSet.getString("ttl");
                data[jmlData][3] = resultSet.getString("kelas");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public String[][] readkelas(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakDataKelas()][4]; //baris, kolom nya ada 4

            String query = "Select * from kelas";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nama"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("pengajar");
                data[jmlData][2] = resultSet.getString("hari");
                data[jmlData][3] = resultSet.getString("durasi");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }













    public String[][] carisiswa(String nama){
        try{
            int jmlData = 0;

            String query = "Select * from siswa WHERE nama LIKE '%" + nama + "%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++; // hitung jumlah data
            }

            String data[][] = new String[jmlData][4]; //baris, kolom nya ada 3


            if (jmlData == 0) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            }
            else {
                jmlData = 0;
                query = "Select * from siswa WHERE nama LIKE '%" + nama + "%'";
                resultSet = statement.executeQuery(query);
                while (resultSet.next()){ // menampilkan data yang memenuhi satu persatu
                    data[jmlData][0] = resultSet.getString("nama"); //harus sesuai nama kolom di mysql
                    data[jmlData][1] = resultSet.getString("alamat");
                    data[jmlData][2] = resultSet.getString("ttl");
                    data[jmlData][3] = resultSet.getString("kelas");
                    jmlData++;
                }

            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public String[][] carikelas(String nama){
        try{
            int jmlData = 0;

            String query = "Select * from kelas WHERE nama LIKE '%" + nama + "%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++; // hitung jumlah data
            }

            String data[][] = new String[jmlData][4]; //baris, kolom nya ada 3


            if (jmlData == 0) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            }
            else {
                jmlData = 0;
                query = "Select * from kelas WHERE nama LIKE '%" + nama + "%'";
                resultSet = statement.executeQuery(query);
                while (resultSet.next()){ // menampilkan data yang memenuhi satu persatu
                    data[jmlData][0] = resultSet.getString("nama"); //harus sesuai nama kolom di mysql
                    data[jmlData][1] = resultSet.getString("pengajar");
                    data[jmlData][2] = resultSet.getString("hari");
                    data[jmlData][3] = resultSet.getString("durasi");
                    jmlData++;
                }

            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }









    public void insertData(String nama, String alamat, String ttl, String kelas){
        int jmlData=0;
        int jmldatakelas = 0;
        try {

            String query = "Select * from siswa WHERE nama= '" + nama +"'"; // cek apakah data sudah ada

            System.out.println(nama + " " + alamat + " " + ttl + " " + kelas);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }
            String query2 = "Select * from kelas WHERE nama= '" + kelas + "'";
            ResultSet resultSet2 = statement.executeQuery(query2);
            while (resultSet2.next()){
                jmldatakelas++;
            }


            if (jmlData==0 && jmldatakelas>=1) { // jika data dengan nama tsb belum ada
                query = "INSERT INTO siswa VALUES('"+nama+"','"+alamat+"','"+ttl+"','"+kelas+"')";

                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Nama sudah ada atau kelas yang anda input tidak ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void insertDataKelas(String nama, String pengajar, String hari, String durasi){
        int jmlData=0;
        try {
            String query = "Select * from kelas WHERE nama= '" + nama +"'"; // cek apakah data sudah ada

            System.out.println(nama + " " + pengajar + " " + hari + " " + durasi);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==0) { // jika data dengan nama tsb belum ada
                query = "INSERT INTO kelas VALUES('"+nama+"','"+pengajar+"','"+hari+"','"+durasi+"')";

                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }





    public void updatesiswa(String nama, String alamat, String ttl, String kelas){
        int jmlData=0;
        try {
            String query = "Select * from siswa WHERE nama='" + nama +"'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==1) { // karena no hp merupakan unique value, maka dapat dipastikan hanya ada satu jika ada
                query = "UPDATE siswa SET alamat='" + alamat + "', ttl='" + ttl + "', kelas='"+ kelas + "' WHERE nama='" + nama +"'";

                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }

        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updateDataKelas(String nama, String pengajar, String hari, String durasi){
        int jmlData=0;
        try {
            String query = "Select * from kelas WHERE nama='" + nama +"'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==1) { // karena no hp merupakan unique value, maka dapat dipastikan hanya ada satu jika ada
                query = "UPDATE kelas SET pengajar='" + pengajar + "', hari='" + hari + "', durasi='"+ durasi + "' WHERE nama='" + nama +"'";

                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }

        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }







    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from siswa";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public int getBanyakDataKelas(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from kelas";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }



    public void deletesiswa (String nama) {
        try{
            String query = "DELETE FROM siswa WHERE nama = '"+nama+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

    public void deletekelas (String nama) {
        try{
            String query = "DELETE FROM kelas WHERE nama = '"+nama+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }




}

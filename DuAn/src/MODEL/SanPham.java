/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import Interface.TableInterface;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gnaht
 */
/**
 *
 * @author vanbi
 */
public class SanPham extends TableInterface {

    private Integer idSanPham;
    private Integer idLoaiSanPham;
    private String TenSanPham;
    private double GiaNhap;
    private double GiaBan;
    private Integer SoLuong;
    private String DVT;

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public Integer getIdLoaiSanPham() {
        return idLoaiSanPham;
    }

    public void setIdLoaiSanPham(Integer idLoaiSanPham) {
        this.idLoaiSanPham = idLoaiSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public Integer getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Integer SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

  

    @Override
    public int getId() {
        return idSanPham;
    }
    
    public class MyTableModel extends AbstractTableModel {

        private List<SanPham> data;

        public MyTableModel() {
            data = new ArrayList<>(25);
        }

        @Override
        public String getColumnName(int column) {
            String value = null;
            switch (column) {
                case 0:
                    value = "ID";
                    break;
                case 1:
                    value = "Name";
                    break;
                case 2:
                    value = "Application for leave";
                    break;
                case 3:
                    value = "Accept/Reject";
                    break;
            }
            return value;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            Class value = Object.class;
            switch (columnIndex) {
                case 0:
                    value = Integer.class;
                    break;
                case 1:
                    value = String.class;
                    break;
                case 2:
                    value = String.class;
                    break;
            }
            return value;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            SanPham obj = data.get(rowIndex);
            Object value = null;
            switch (columnIndex) {
                case 0:
                    value = obj.getIdSanPham();
                    break;
                case 1:
                    value = obj.getTenSanPham();
                    break;
                case 2:
                    value = obj.getGiaBan();
                    break;
                case 3:
                    break;
            }
            return value;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (columnIndex == 3) {

                System.out.println(aValue);

                SanPham value = data.get(rowIndex);
                if ("accept".equals(aValue)) {
                    System.out.println("Accepted");
                } else {
                    System.out.println("Rejected");
                }
                fireTableCellUpdated(rowIndex, columnIndex);
                remove(value);

            }
        }

        public void add(SanPham value) {
            int startIndex = getRowCount();
            data.add(value);
            fireTableRowsInserted(startIndex, getRowCount() - 1);
        }

        public void remove(SanPham value) {
            int startIndex = data.indexOf(value);
            System.out.println("startIndex = " + startIndex);
            data.remove(value);
            fireTableRowsInserted(startIndex, startIndex);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 3;
        }
    }
}

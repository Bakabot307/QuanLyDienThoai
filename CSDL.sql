USE [quanly_dienthoai]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 12/16/2021 10:47:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[idChiTietHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[idSanPham] [int] NOT NULL,
	[idChiTietSanPham] [int] NOT NULL,
	[idHoaDon] [int] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[Gia] [float] NOT NULL,
	[TongTien] [float] NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[idChiTietHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhieuNhap]    Script Date: 12/16/2021 10:47:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuNhap](
	[idChiTietPhieuNhap] [int] IDENTITY(1,1) NOT NULL,
	[idPhieuNhap] [int] NOT NULL,
	[idSanPham] [int] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[GiaTien] [float] NOT NULL,
	[TongTien] [float] NOT NULL,
 CONSTRAINT [PK_ChiTietPhieuNhap_1] PRIMARY KEY CLUSTERED 
(
	[idChiTietPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietSanPham]    Script Date: 12/16/2021 10:47:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSanPham](
	[idChiTietSanPham] [int] IDENTITY(1,1) NOT NULL,
	[DungLuong] [nvarchar](50) NOT NULL,
	[idSanPham] [int] NOT NULL,
	[MauSac] [nvarchar](15) NOT NULL,
	[HangSanXuat] [nvarchar](55) NOT NULL,
	[SoLuong] [int] NOT NULL,
 CONSTRAINT [PK_ChiTietSanPham_1] PRIMARY KEY CLUSTERED 
(
	[idChiTietSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DANHMUC]    Script Date: 12/16/2021 10:47:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DANHMUC](
	[maDanhMuc] [int] IDENTITY(1,1) NOT NULL,
	[tenDanhMuc] [nvarchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maDanhMuc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 12/16/2021 10:47:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[idHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[idKhachHang] [int] NULL,
	[idNhanVien] [int] NOT NULL,
	[idKhuyenMai] [int] NULL,
	[SoLuong] [int] NOT NULL,
	[TongTien] [float] NOT NULL,
	[NgayLap] [datetime] NOT NULL,
	[HinhThucThanhToan] [nvarchar](55) NOT NULL,
	[GhiChu] [nvarchar](150) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[idHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/16/2021 10:47:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[idKhachHang] [int] IDENTITY(1,1) NOT NULL,
	[TenKhachHang] [nvarchar](55) NOT NULL,
	[SoDienThoai] [varchar](15) NOT NULL,
	[DiaChi] [nvarchar](150) NOT NULL,
	[CMND] [varchar](9) NOT NULL,
	[GhiChu] [nvarchar](150) NULL,
	[GioiTInh] [nvarchar](4) NOT NULL,
	[Email] [nvarchar](55) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[idKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHOHANG]    Script Date: 12/16/2021 10:47:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHOHANG](
	[maSanPham] [int] NOT NULL,
	[soLuong] [int] NOT NULL,
	[giaNhap] [float] NOT NULL,
	[giaBan] [float] NOT NULL,
	[maPhieuNhap] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 12/16/2021 10:47:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[idKhuyenMai] [int] IDENTITY(1,1) NOT NULL,
	[TenKhuyenMai] [nvarchar](55) NOT NULL,
	[PhanTramKhuyenMai] [int] NOT NULL,
	[GhiChu] [nvarchar](150) NULL,
 CONSTRAINT [PK_KhuyenMai] PRIMARY KEY CLUSTERED 
(
	[idKhuyenMai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 12/16/2021 10:47:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[idLoaiSanPham] [int] IDENTITY(1,1) NOT NULL,
	[TenLoaiSanPham] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_idLoaiSanPham] PRIMARY KEY CLUSTERED 
(
	[idLoaiSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 12/16/2021 10:47:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[idNhaCungCap] [int] IDENTITY(1,1) NOT NULL,
	[TenNhaCungCap] [nvarchar](155) NOT NULL,
	[SoDienThoai] [varchar](15) NOT NULL,
	[Email] [nvarchar](55) NOT NULL,
	[TongMua] [float] NOT NULL,
	[DiaChi] [nvarchar](150) NOT NULL,
	[GhiChu] [nvarchar](150) NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[idNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/16/2021 10:47:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[idNhanVien] [int] IDENTITY(1,1) NOT NULL,
	[TenNhanVien] [nvarchar](55) NOT NULL,
	[GioiTinh] [nvarchar](4) NOT NULL,
	[DiaChi] [nchar](10) NOT NULL,
	[CMND] [varchar](9) NOT NULL,
	[SoDienThoai] [varchar](15) NOT NULL,
	[Email] [nvarchar](55) NULL,
	[NgayVaoLam] [date] NOT NULL,
	[Lv] [int] NOT NULL,
	[TenDangNhap] [varchar](50) NOT NULL,
	[MatKhau] [varchar](50) NOT NULL,
	[TrangThai] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[idNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuBaoHanh]    Script Date: 12/16/2021 10:47:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuBaoHanh](
	[idPhieuBaoHanh] [int] IDENTITY(1,1) NOT NULL,
	[idHoaDon] [int] NOT NULL,
	[idKhachHang] [int] NOT NULL,
	[idNhanVien] [int] NOT NULL,
	[NgayLap] [datetime] NOT NULL,
	[LyDo] [nvarchar](150) NOT NULL,
	[ThoiGianBaoTri] [nvarchar](50) NOT NULL,
	[TrangThai] [nvarchar](50) NOT NULL,
	[ChiPhiBaoHanh] [float] NOT NULL,
	[GhiChu] [nvarchar](150) NULL,
 CONSTRAINT [PK_PhieuBaoHang] PRIMARY KEY CLUSTERED 
(
	[idPhieuBaoHanh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhap]    Script Date: 12/16/2021 10:47:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhap](
	[idPhieuNhap] [int] IDENTITY(1,1) NOT NULL,
	[idNhaCungCap] [int] NOT NULL,
	[NgayNhap] [datetime] NOT NULL,
	[TongTien] [float] NOT NULL,
	[TrangThai] [nvarchar](50) NOT NULL,
	[SoLuong] [int] NOT NULL,
 CONSTRAINT [PK_PhieuNhap] PRIMARY KEY CLUSTERED 
(
	[idPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 12/16/2021 10:47:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[idSanPham] [int] IDENTITY(1,1) NOT NULL,
	[idLoaiSanPham] [int] NOT NULL,
	[TenSanPham] [nvarchar](150) NOT NULL,
	[GiaNhap] [float] NOT NULL,
	[GiaBan] [float] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[DVT] [nvarchar](15) NOT NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[idSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SUKIEN]    Script Date: 12/16/2021 10:47:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SUKIEN](
	[maKhuyenMai] [int] IDENTITY(1,1) NOT NULL,
	[giaTriKhuyenMai] [int] NOT NULL,
	[ngayBatDau] [varchar](20) NOT NULL,
	[ngayKetThuc] [varchar](20) NOT NULL,
	[noiDungKhuyenMai] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maKhuyenMai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_ChiTietSanPham1] FOREIGN KEY([idChiTietSanPham])
REFERENCES [dbo].[ChiTietSanPham] ([idChiTietSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_ChiTietSanPham1]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon1] FOREIGN KEY([idHoaDon])
REFERENCES [dbo].[HoaDon] ([idHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon1]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_SanPham] FOREIGN KEY([idSanPham])
REFERENCES [dbo].[SanPham] ([idSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_SanPham]
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuNhap_PhieuNhap] FOREIGN KEY([idPhieuNhap])
REFERENCES [dbo].[PhieuNhap] ([idPhieuNhap])
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap] CHECK CONSTRAINT [FK_ChiTietPhieuNhap_PhieuNhap]
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuNhap_SanPham] FOREIGN KEY([idSanPham])
REFERENCES [dbo].[SanPham] ([idSanPham])
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap] CHECK CONSTRAINT [FK_ChiTietPhieuNhap_SanPham]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietSanPham_SanPham1] FOREIGN KEY([idSanPham])
REFERENCES [dbo].[SanPham] ([idSanPham])
GO
ALTER TABLE [dbo].[ChiTietSanPham] CHECK CONSTRAINT [FK_ChiTietSanPham_SanPham1]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([idKhachHang])
REFERENCES [dbo].[KhachHang] ([idKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhuyenMai] FOREIGN KEY([idKhuyenMai])
REFERENCES [dbo].[KhuyenMai] ([idKhuyenMai])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhuyenMai]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[NhanVien] ([idNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[PhieuBaoHanh]  WITH CHECK ADD  CONSTRAINT [FK_PhieuBaoHang_NhanVien] FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[NhanVien] ([idNhanVien])
GO
ALTER TABLE [dbo].[PhieuBaoHanh] CHECK CONSTRAINT [FK_PhieuBaoHang_NhanVien]
GO
ALTER TABLE [dbo].[PhieuBaoHanh]  WITH CHECK ADD  CONSTRAINT [FK_PhieuBaoHanh_KhachHang] FOREIGN KEY([idKhachHang])
REFERENCES [dbo].[KhachHang] ([idKhachHang])
GO
ALTER TABLE [dbo].[PhieuBaoHanh] CHECK CONSTRAINT [FK_PhieuBaoHanh_KhachHang]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhap_NhaCungCap] FOREIGN KEY([idNhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([idNhaCungCap])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK_PhieuNhap_NhaCungCap]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_idLoaiSanPham] FOREIGN KEY([idLoaiSanPham])
REFERENCES [dbo].[LoaiSanPham] ([idLoaiSanPham])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_idLoaiSanPham]
GO

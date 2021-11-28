USE [quanly_dienthoai]
GO
ALTER TABLE [dbo].[SanPham] DROP CONSTRAINT [FK_SanPham_idLoaiSanPham]
GO
ALTER TABLE [dbo].[PhieuNhap] DROP CONSTRAINT [FK_PhieuNhap_NhaCungCap]
GO
ALTER TABLE [dbo].[PhieuBaoHanh] DROP CONSTRAINT [FK_PhieuBaoHanh_KhachHang]
GO
ALTER TABLE [dbo].[PhieuBaoHanh] DROP CONSTRAINT [FK_PhieuBaoHang_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon] DROP CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon] DROP CONSTRAINT [FK_HoaDon_KhuyenMai]
GO
ALTER TABLE [dbo].[HoaDon] DROP CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[ChiTietSanPham] DROP CONSTRAINT [FK_ChiTietSanPham_SanPham1]
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap] DROP CONSTRAINT [FK_ChiTietPhieuNhap_SanPham]
GO
ALTER TABLE [dbo].[ChiTietPhieuNhap] DROP CONSTRAINT [FK_ChiTietPhieuNhap_PhieuNhap]
GO
ALTER TABLE [dbo].[ChiTietHoaDon] DROP CONSTRAINT [FK_ChiTietHoaDon_SanPham]
GO
ALTER TABLE [dbo].[ChiTietHoaDon] DROP CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 11/28/2021 22:43:08 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[SanPham]') AND type in (N'U'))
DROP TABLE [dbo].[SanPham]
GO
/****** Object:  Table [dbo].[PhieuNhap]    Script Date: 11/28/2021 22:43:08 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[PhieuNhap]') AND type in (N'U'))
DROP TABLE [dbo].[PhieuNhap]
GO
/****** Object:  Table [dbo].[PhieuBaoHanh]    Script Date: 11/28/2021 22:43:08 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[PhieuBaoHanh]') AND type in (N'U'))
DROP TABLE [dbo].[PhieuBaoHanh]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/28/2021 22:43:08 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[NhanVien]') AND type in (N'U'))
DROP TABLE [dbo].[NhanVien]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 11/28/2021 22:43:08 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[NhaCungCap]') AND type in (N'U'))
DROP TABLE [dbo].[NhaCungCap]
GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 11/28/2021 22:43:08 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[LoaiSanPham]') AND type in (N'U'))
DROP TABLE [dbo].[LoaiSanPham]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 11/28/2021 22:43:08 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[KhuyenMai]') AND type in (N'U'))
DROP TABLE [dbo].[KhuyenMai]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/28/2021 22:43:08 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[KhachHang]') AND type in (N'U'))
DROP TABLE [dbo].[KhachHang]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/28/2021 22:43:08 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[HoaDon]') AND type in (N'U'))
DROP TABLE [dbo].[HoaDon]
GO
/****** Object:  Table [dbo].[ChiTietSanPham]    Script Date: 11/28/2021 22:43:08 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ChiTietSanPham]') AND type in (N'U'))
DROP TABLE [dbo].[ChiTietSanPham]
GO
/****** Object:  Table [dbo].[ChiTietPhieuNhap]    Script Date: 11/28/2021 22:43:08 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ChiTietPhieuNhap]') AND type in (N'U'))
DROP TABLE [dbo].[ChiTietPhieuNhap]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 11/28/2021 22:43:08 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ChiTietHoaDon]') AND type in (N'U'))
DROP TABLE [dbo].[ChiTietHoaDon]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 11/28/2021 22:43:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[idChiTietHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[idSanPham] [int] NOT NULL,
	[idHoaDon] [int] NOT NULL,
	[TenSanPham] [nvarchar](150) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[Gia] [float] NOT NULL,
	[GhiChu] [nvarchar](150) NULL,
	[TongTien] [float] NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[idChiTietHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhieuNhap]    Script Date: 11/28/2021 22:43:08 ******/
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
/****** Object:  Table [dbo].[ChiTietSanPham]    Script Date: 11/28/2021 22:43:08 ******/
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
 CONSTRAINT [PK_ChiTietSanPham_1] PRIMARY KEY CLUSTERED 
(
	[idChiTietSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/28/2021 22:43:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[idHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[idKhachHang] [int] NOT NULL,
	[idNhanVien] [int] NOT NULL,
	[idKhuyenMai] [int] NULL,
	[TongTien] [float] NOT NULL,
	[NgayLap] [datetime] NOT NULL,
	[HinhThucThanhToan] [nvarchar](55) NOT NULL,
	[TrangThai] [nvarchar](50) NOT NULL,
	[GhiChu] [nvarchar](150) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[idHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/28/2021 22:43:08 ******/
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
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 11/28/2021 22:43:09 ******/
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
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 11/28/2021 22:43:09 ******/
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
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 11/28/2021 22:43:09 ******/
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
	[GhiChu] [nvarchar](150) NULL,
	[DiaChi] [nvarchar](150) NOT NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[idNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/28/2021 22:43:09 ******/
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
/****** Object:  Table [dbo].[PhieuBaoHanh]    Script Date: 11/28/2021 22:43:09 ******/
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
/****** Object:  Table [dbo].[PhieuNhap]    Script Date: 11/28/2021 22:43:09 ******/
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
/****** Object:  Table [dbo].[SanPham]    Script Date: 11/28/2021 22:43:09 ******/
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
SET IDENTITY_INSERT [dbo].[ChiTietPhieuNhap] ON 

INSERT [dbo].[ChiTietPhieuNhap] ([idChiTietPhieuNhap], [idPhieuNhap], [idSanPham], [SoLuong], [GiaTien], [TongTien]) VALUES (0, 1, 1, 1, 1, 1)
INSERT [dbo].[ChiTietPhieuNhap] ([idChiTietPhieuNhap], [idPhieuNhap], [idSanPham], [SoLuong], [GiaTien], [TongTien]) VALUES (1, 1, 1, 2, 100000, 100000)
INSERT [dbo].[ChiTietPhieuNhap] ([idChiTietPhieuNhap], [idPhieuNhap], [idSanPham], [SoLuong], [GiaTien], [TongTien]) VALUES (3, 2, 5, 2, 2, 2)
INSERT [dbo].[ChiTietPhieuNhap] ([idChiTietPhieuNhap], [idPhieuNhap], [idSanPham], [SoLuong], [GiaTien], [TongTien]) VALUES (4, 1, 1, 2, 1, 1)
INSERT [dbo].[ChiTietPhieuNhap] ([idChiTietPhieuNhap], [idPhieuNhap], [idSanPham], [SoLuong], [GiaTien], [TongTien]) VALUES (5, 1, 1, 8, 1, 1)
INSERT [dbo].[ChiTietPhieuNhap] ([idChiTietPhieuNhap], [idPhieuNhap], [idSanPham], [SoLuong], [GiaTien], [TongTien]) VALUES (6, 1, 1, 4, 1, 1)
INSERT [dbo].[ChiTietPhieuNhap] ([idChiTietPhieuNhap], [idPhieuNhap], [idSanPham], [SoLuong], [GiaTien], [TongTien]) VALUES (7, 1, 1, 10, 1, 1111)
INSERT [dbo].[ChiTietPhieuNhap] ([idChiTietPhieuNhap], [idPhieuNhap], [idSanPham], [SoLuong], [GiaTien], [TongTien]) VALUES (8, 1, 1, 2, 50000, 100000)
SET IDENTITY_INSERT [dbo].[ChiTietPhieuNhap] OFF
GO
SET IDENTITY_INSERT [dbo].[ChiTietSanPham] ON 

INSERT [dbo].[ChiTietSanPham] ([idChiTietSanPham], [DungLuong], [idSanPham], [MauSac], [HangSanXuat]) VALUES (1, N'15GB', 1, N'Xanh', N'Nokia')
SET IDENTITY_INSERT [dbo].[ChiTietSanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([idHoaDon], [idKhachHang], [idNhanVien], [idKhuyenMai], [TongTien], [NgayLap], [HinhThucThanhToan], [TrangThai], [GhiChu]) VALUES (2, 1, 2, 1, 1, CAST(N'2021-02-02T00:00:00.000' AS DateTime), N'Thẻ', N'xong', N'khong')
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (1, N'Nguyễn văn Tịnh', N'0123123123', N'HCM', N'241567973', N'Không', N'Nam', N'hoang@gmail.com')
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (2, N'abc`', N'123', N'132', N'132', N'123123123', N'Nữ', N'123')
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (3, N'1', N'ád', N'ád', N'ads', N'ád', N'Nữ', N'')
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (4, N'', N'', N'', N'', N'', N'Nữ', N'')
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (5, N'', N'', N'', N'', N'', N'Nữ', N'')
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (6, N'1', N'1', N'1', N'1', N'1', N'Nam', N'1')
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (7, N'1', N'1', N'22', N'22', N'2', N'Nữ', N'2')
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (8, N'1', N'1', N'22', N'22', N'2', N'Nữ', N'2')
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (9, N'', N'', N'', N'', N'', N'Nữ', N'')
INSERT [dbo].[KhachHang] ([idKhachHang], [TenKhachHang], [SoDienThoai], [DiaChi], [CMND], [GhiChu], [GioiTInh], [Email]) VALUES (10, N'', N'', N'', N'', N'', N'Nữ', N'')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[KhuyenMai] ON 

INSERT [dbo].[KhuyenMai] ([idKhuyenMai], [TenKhuyenMai], [PhanTramKhuyenMai], [GhiChu]) VALUES (1, N'20/11', 3, N'Không')
INSERT [dbo].[KhuyenMai] ([idKhuyenMai], [TenKhuyenMai], [PhanTramKhuyenMai], [GhiChu]) VALUES (9, N'Black Friday', 20, N'Không')
SET IDENTITY_INSERT [dbo].[KhuyenMai] OFF
GO
SET IDENTITY_INSERT [dbo].[LoaiSanPham] ON 

INSERT [dbo].[LoaiSanPham] ([idLoaiSanPham], [TenLoaiSanPham]) VALUES (1, N'Phụ kiện Oppo')
INSERT [dbo].[LoaiSanPham] ([idLoaiSanPham], [TenLoaiSanPham]) VALUES (2, N'OKd')
INSERT [dbo].[LoaiSanPham] ([idLoaiSanPham], [TenLoaiSanPham]) VALUES (3, N'OKde')
INSERT [dbo].[LoaiSanPham] ([idLoaiSanPham], [TenLoaiSanPham]) VALUES (4, N'OKde')
INSERT [dbo].[LoaiSanPham] ([idLoaiSanPham], [TenLoaiSanPham]) VALUES (5, N'sad')
SET IDENTITY_INSERT [dbo].[LoaiSanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[NhaCungCap] ON 

INSERT [dbo].[NhaCungCap] ([idNhaCungCap], [TenNhaCungCap], [SoDienThoai], [Email], [TongMua], [GhiChu], [DiaChi]) VALUES (1, N'Cty Hòa Tân', N'01231231123', N'gh@gmail.com', 20000000, N'Không', N'HCM')
SET IDENTITY_INSERT [dbo].[NhaCungCap] OFF
GO
SET IDENTITY_INSERT [dbo].[NhanVien] ON 

INSERT [dbo].[NhanVien] ([idNhanVien], [TenNhanVien], [GioiTinh], [DiaChi], [CMND], [SoDienThoai], [Email], [NgayVaoLam], [Lv], [TenDangNhap], [MatKhau], [TrangThai]) VALUES (2, N'Nguyễn Thị Nga', N'Nữ', N'Hà Nội    ', N'241241241', N'0123123791', N'nga@gmail.com', CAST(N'2021-12-10' AS Date), 1, N'admin', N'123', N'Đang làm')
INSERT [dbo].[NhanVien] ([idNhanVien], [TenNhanVien], [GioiTinh], [DiaChi], [CMND], [SoDienThoai], [Email], [NgayVaoLam], [Lv], [TenDangNhap], [MatKhau], [TrangThai]) VALUES (3, N'Hoàng Ha', N'Nam', N'AC        ', N'12312', N'123123', N'123123', CAST(N'2020-10-10' AS Date), 2, N'abc', N'1234', N'Nghỉ')
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
GO
SET IDENTITY_INSERT [dbo].[PhieuBaoHanh] ON 

INSERT [dbo].[PhieuBaoHanh] ([idPhieuBaoHanh], [idHoaDon], [idKhachHang], [idNhanVien], [NgayLap], [LyDo], [ThoiGianBaoTri], [TrangThai], [ChiPhiBaoHanh], [GhiChu]) VALUES (2, 1, 1, 2, CAST(N'2021-02-02T00:00:00.000' AS DateTime), N'hỏng màn', N'10day', N'đang sửa', 50000, N'không')
INSERT [dbo].[PhieuBaoHanh] ([idPhieuBaoHanh], [idHoaDon], [idKhachHang], [idNhanVien], [NgayLap], [LyDo], [ThoiGianBaoTri], [TrangThai], [ChiPhiBaoHanh], [GhiChu]) VALUES (10, 2, 1, 2, CAST(N'2021-11-28T22:30:08.613' AS DateTime), N'ád', N'ádasd', N'ádasd', 111, N'okkkkkk')
INSERT [dbo].[PhieuBaoHanh] ([idPhieuBaoHanh], [idHoaDon], [idKhachHang], [idNhanVien], [NgayLap], [LyDo], [ThoiGianBaoTri], [TrangThai], [ChiPhiBaoHanh], [GhiChu]) VALUES (18, 2, 1, 2, CAST(N'2021-11-28T22:30:16.733' AS DateTime), N'ád', N'ádasd', N'ádasd', 111, N'okkkkkkádasdasd')
INSERT [dbo].[PhieuBaoHanh] ([idPhieuBaoHanh], [idHoaDon], [idKhachHang], [idNhanVien], [NgayLap], [LyDo], [ThoiGianBaoTri], [TrangThai], [ChiPhiBaoHanh], [GhiChu]) VALUES (19, 2, 7, 2, CAST(N'2021-11-28T22:40:32.373' AS DateTime), N'1', N'1', N'1', 1213123, N'1')
INSERT [dbo].[PhieuBaoHanh] ([idPhieuBaoHanh], [idHoaDon], [idKhachHang], [idNhanVien], [NgayLap], [LyDo], [ThoiGianBaoTri], [TrangThai], [ChiPhiBaoHanh], [GhiChu]) VALUES (21, 2, 1, 2, CAST(N'2021-11-28T22:40:10.733' AS DateTime), N'1', N'1', N'1', 1213123, N'1')
SET IDENTITY_INSERT [dbo].[PhieuBaoHanh] OFF
GO
SET IDENTITY_INSERT [dbo].[PhieuNhap] ON 

INSERT [dbo].[PhieuNhap] ([idPhieuNhap], [idNhaCungCap], [NgayNhap], [TongTien], [TrangThai], [SoLuong]) VALUES (1, 1, CAST(N'2021-11-26T00:00:00.000' AS DateTime), 1000000, N'Đã nhập', 10)
INSERT [dbo].[PhieuNhap] ([idPhieuNhap], [idNhaCungCap], [NgayNhap], [TongTien], [TrangThai], [SoLuong]) VALUES (2, 1, CAST(N'2021-11-26T16:18:07.863' AS DateTime), 900, N'Chờ', 1)
INSERT [dbo].[PhieuNhap] ([idPhieuNhap], [idNhaCungCap], [NgayNhap], [TongTien], [TrangThai], [SoLuong]) VALUES (3, 1, CAST(N'2021-11-26T16:18:11.590' AS DateTime), 900, N'Chờ', 1)
INSERT [dbo].[PhieuNhap] ([idPhieuNhap], [idNhaCungCap], [NgayNhap], [TongTien], [TrangThai], [SoLuong]) VALUES (4, 1, CAST(N'2021-11-26T16:18:11.647' AS DateTime), 900, N'Chờ', 1)
INSERT [dbo].[PhieuNhap] ([idPhieuNhap], [idNhaCungCap], [NgayNhap], [TongTien], [TrangThai], [SoLuong]) VALUES (5, 1, CAST(N'2021-11-26T16:18:15.240' AS DateTime), 900, N'Chờ', 1)
INSERT [dbo].[PhieuNhap] ([idPhieuNhap], [idNhaCungCap], [NgayNhap], [TongTien], [TrangThai], [SoLuong]) VALUES (6, 1, CAST(N'2021-11-26T16:18:15.297' AS DateTime), 900, N'Chờ', 1)
INSERT [dbo].[PhieuNhap] ([idPhieuNhap], [idNhaCungCap], [NgayNhap], [TongTien], [TrangThai], [SoLuong]) VALUES (7, 1, CAST(N'2021-11-26T16:18:15.360' AS DateTime), 900, N'Chờ', 1)
INSERT [dbo].[PhieuNhap] ([idPhieuNhap], [idNhaCungCap], [NgayNhap], [TongTien], [TrangThai], [SoLuong]) VALUES (8, 1, CAST(N'2021-11-26T16:24:31.887' AS DateTime), 1, N'1', 2)
INSERT [dbo].[PhieuNhap] ([idPhieuNhap], [idNhaCungCap], [NgayNhap], [TongTien], [TrangThai], [SoLuong]) VALUES (9, 1, CAST(N'2021-11-26T16:24:37.007' AS DateTime), 1, N'1', 4)
SET IDENTITY_INSERT [dbo].[PhieuNhap] OFF
GO
SET IDENTITY_INSERT [dbo].[SanPham] ON 

INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (1, 1, N'Phụ kiện Oppo', 30000, 50000, 4, N'Abc')
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (5, 1, N'1', 1, 1, 1, N'1')
INSERT [dbo].[SanPham] ([idSanPham], [idLoaiSanPham], [TenSanPham], [GiaNhap], [GiaBan], [SoLuong], [DVT]) VALUES (6, 2, N'1', 2, 2, 1, N'2')
SET IDENTITY_INSERT [dbo].[SanPham] OFF
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([idHoaDon])
REFERENCES [dbo].[HoaDon] ([idHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
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

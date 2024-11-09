/*
 Person  V
 Roles V
 Acccount  V
 Wallets  V
 Categories  V
 ShowRoom V
 Products V
 Phone  V --
 Laptop V --
 Headphones  V --
 ShowRoomDetail  V
 Comment  V
 Orders  V
 Gift  V
 OrderDeT  V
 Deposit V


*/
--create database DBGR2Final9
---drop database Test2
--use  DBGR2Final9

--drop table Person
CREATE TABLE Roles (
    RoleID INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    RoleName NVARCHAR(50) NOT NULL
);

CREATE TABLE Person(
    PersonID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    Name NVARCHAR(50),
    Gender NVARCHAR(6) null,
    DateOfBirth DATE not null,
	StartDate Date null,
    Email VARCHAR(100) not null unique,
    RoleID int not null,
	Password VARCHAR(50) NOT NULL,
	FOREIGN KEY (RoleID) REFERENCES Roles(RoleID)
);
CREATE TABLE PersonAddress (
    AddressID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    PersonID INT NOT NULL,
    Address NVARCHAR(200) NOT NULL,
    IsPrimary BIT NOT NULL DEFAULT 0, -- Đánh dấu địa chỉ chính
    FOREIGN KEY (PersonID) REFERENCES Person(PersonID)
);
CREATE TABLE PersonPhone (
    PhoneID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    PersonID INT NOT NULL,
    Phone VARCHAR(15) NOT NULL,
    IsPrimary BIT NOT NULL DEFAULT 0, -- Đánh dấu số điện thoại chính
    FOREIGN KEY (PersonID) REFERENCES Person(PersonID)
);
CREATE TABLE PersonImages (
    image_id int IDENTITY(1,1) NOT NULL PRIMARY KEY,
    PersonID INT,
    image_url NVARCHAR(250),
    alt_text NVARCHAR(250),
	IsPrimary BIT NOT NULL DEFAULT 0, -- Đánh dấu ảnh hiển thị chính
    FOREIGN KEY (PersonID) REFERENCES Person(PersonID)
);
CREATE TABLE PersonVideo (
    image_id int IDENTITY(1,1) NOT NULL PRIMARY KEY,
    PersonID INT,
    Video_url NVARCHAR(250),
    alt_text NVARCHAR(250),
	IsPrimary BIT NOT NULL DEFAULT 0, -- Đánh dấu video chính
    FOREIGN KEY (PersonID) REFERENCES Person(PersonID)
);
CREATE TABLE HistoryChange (
    HistoryID INT PRIMARY KEY IDENTITY(1,1), -- ID duy nhất cho mỗi bản ghi thay đổi
    PersonID INT NOT NULL,                   -- ID của người dùng (liên kết đến bảng Person)
    Email NVARCHAR(255),                     -- Email của khách hàng tại thời điểm thay đổi
    FullName NVARCHAR(255),                  -- Họ tên của khách hàng tại thời điểm thay đổi
    Gender NVARCHAR(50),                     -- Giới tính tại thời điểm thay đổi
    Mobile NVARCHAR(20),                     -- Số điện thoại tại thời điểm thay đổi
    Address NVARCHAR(255),                   -- Địa chỉ tại thời điểm thay đổi
    UpdatedBy NVARCHAR(255),                 -- Người thực hiện cập nhật
    UpdatedDate DATETIME DEFAULT GETDATE()   -- Ngày cập nhật (tự động lấy ngày hiện tại)
	FOREIGN KEY (PersonID) REFERENCES Person(PersonID)
);

--drop table Wallets
CREATE TABLE Wallets (
    WalletID INT IDENTITY(1,1) not null  PRIMARY KEY ,--Mã d?nh danh duy nh?t cho m?i ví di?n t?.
    Balance DECIMAL(10, 2),--S? du trong ví di?n t?
	PersonID int not null,
    FOREIGN KEY (PersonID) REFERENCES Person(PersonID)
 );

--drop table Categories
CREATE TABLE Categories (
    CategoryID INT IDENTITY(1,1) NOT NULL ,--: Mã d?nh danh duy nh?t cho m?i th? lo?i.
    CategoryName [nvarchar](50) COLLATE Vietnamese_CI_AS NOT NULL,--Tên c?a th? lo?i phim.
    [Description] [nvarchar](MAX) COLLATE Vietnamese_CI_AS NULL--Mô t? v? th? lo?i (có th? d? tr?ng).
	CONSTRAINT [PK_Categories] PRIMARY KEY([CategoryID])
);

CREATE TABLE ShowRoom (
    [ShowRoomID] INT IDENTITY(1,1) NOT NULL PRIMARY KEY,-- Mã d?nh danh duy nh?t cho m?i r?p chi?u phim.
    [ShowRoomName] NVARCHAR(100) NOT NULL,--Tên c?a r?p chi?u phim.
    [Address] NVARCHAR(500) NOT NULL--Ð?a ch? c?a r?p chi?u phim.
);

--drop table Products
CREATE TABLE Products (
    [ProductID] int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	title nvarchar(250) not null ,
	ProductName nvarchar(250) not null,
    [Views] int NULL,--So luot xem san pham 
    [releaseDate] DATE NULL,--Ngay phat hanh san pham.
    [QuantitySold] INT NULL,--So luong san pham da ban
    [CategoryID] INT NULL,
    Quantity int not null,
	Sale int not null,
	brand NVARCHAR(50) not null,
	img nvarchar(250) not null,
	price DECIMAL(10, 2) not null,
	publisher nvarchar(200) not null,
	sortDescription nvarchar(200) null,
	[description] nvarchar(250) null,
	[status]  nvarchar(250) null,
    CONSTRAINT [FK_Products_Category] FOREIGN KEY ([CategoryID]) REFERENCES [dbo].[Categories] ([CategoryID])
);
CREATE TABLE ProductImages (
    image_id int IDENTITY(1,1) NOT NULL PRIMARY KEY,
    ProductID INT,
    image_url NVARCHAR(250),
    alt_text NVARCHAR(250),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE ProductAttributes (
    AttributeID int IDENTITY(1,1) PRIMARY KEY,
    ProductID int NOT NULL, -- Tham chiếu đến bảng Products
    AttributeName nvarchar(255) NOT NULL, -- Tên thuộc tính, VD: "RAM", "ScreenSize", "Battery"
    AttributeValue nvarchar(255) NOT NULL, -- Giá trị thuộc tính, VD: "8GB", "6.5 inch", "4000mAh"
	FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);
 
 
--drop table ShowRoomDetail
Create table ShowRoomDetail(
   ShowRoomID int not null,
   ProductID int not null,
   CONSTRAINT [FK_ShowRoomDetail_Product] FOREIGN KEY (ProductID) REFERENCES [dbo].[Products] (ProductID),
   CONSTRAINT [FK_ShowRoomDetail_ShowRoom] FOREIGN KEY ([ShowRoomID]) REFERENCES [dbo].[ShowRoom] ([ShowRoomID])
);

Create table Comment(
comment_id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
ProductID int not null,
PersonID  int not null,
CommentDetail nvarchar(255) not null,
created_at date not null,
--Rate int check (Rate BETWEEN 1 AND 5),
--Favorite int check (Favorite In (0,1)),
FOREIGN KEY (ProductID) REFERENCES Products(ProductID),
FOREIGN KEY (PersonID) REFERENCES Person(PersonID)
);

CREATE TABLE CommentImages (
    image_id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    comment_id INT,
    image_url VARCHAR(255),
	image_text nvarchar(255),
    FOREIGN KEY (comment_id) REFERENCES Comment(comment_id)
)
CREATE TABLE CommentVideos (
    video_id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    comment_id INT,
    video_url VARCHAR(255),
	video_text nvarchar(255),
    FOREIGN KEY (comment_id) REFERENCES Comment(comment_id)
);


CREATE TABLE Orders (
    OrderID INT IDENTITY(1,1) NOT NULL PRIMARY KEY,--Mã d?nh danh duy nh?t cho m?i don d?t hàng.
    [OrderDate] DATETIME NOT NULL DEFAULT GETDATE(),  --Ngày và gi? d?t hàng.
    PersonID int NOT NULL,--Khóa ngo?i liên k?t v?i b?ng Account, xác d?nh ngu?i dùng dã d?t hàng.
    ShowRoomID INT NOT NULL,--Khóa ngo?i liên k?t v?i b?ng Rooms, xác d?nh phòng chi?u du?c d?t.
    TotalMoney DECIMAL(10, 2) NOT NULL DEFAULT 0,--T?ng s? ti?n c?a don hàng.
    Method NVARCHAR(MAX) NOT NULL,-- Phuong th?c thanh toán.
	SaleID int null, -- ID c?a nhân viên sale
	[Status] nvarchar(255) not null,--trang thai don hang
	SaleNote nvarchar(max) not null,
	ShipStatus nvarchar(255) not null,
	receivedDate DATETIME,
	FOREIGN KEY (SaleID) REFERENCES  Person(PersonID),
	FOREIGN KEY (ShowRoomID) REFERENCES  ShowRoom(ShowRoomID),
    FOREIGN KEY (PersonID) REFERENCES Person(PersonID)
);

--drop table Gift
CREATE TABLE Gift (
    GiftID INT IDENTITY(1,1) NOT NULL PRIMARY KEY,--Mã d?nh danh duy nh?t cho m?i món an ho?c th?c u?ng.  
    GiftName NVARCHAR(50) NOT NULL,--Tên c?a món an ho?c th?c u?ng.
    Quantity int not null,
	[image] VARCHAR(255),
);
--drop table OrderDetails


CREATE TABLE OrderDetails (
    OrderDetailID INT IDENTITY(1,1) NOT NULL PRIMARY KEY,--Mã d?nh danh duy nh?t cho m?i m?c chi ti?t don hàng.
    OrderID INT NOT NULL,--Khóa ngo?i liên k?t v?i b?ng Orders, xác d?nh don hàng ch?a m?c này.
    ProductID INT NULL,--Khóa ngo?i liên k?t v?i b?ng Products, xác d?nh s?n ph?m (phim) trong don hàng.
    GiftID INT NULL, -- Khóa ngo?i liên k?t v?i b?ng FoodandDrink, xác d?nh món an ho?c th?c u?ng trong don hàng.
    Quantity INT NOT NULL,--S? lu?ng c?a m?c này trong don hàng.
	UnitPrice DECIMAL(10, 2) NOT NULL, --Ðon giá
    TotalCost DECIMAL(10, 2) NOT NULL, --T?ng giá
    CONSTRAINT FK_OrderDetails_Orders FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    CONSTRAINT FK_OrderDetails_Products FOREIGN KEY (ProductID) REFERENCES Products(ProductID),
    CONSTRAINT FK_OrderDetails_FoodAndDrink FOREIGN KEY (GiftID) REFERENCES Gift(GiftID)
);


CREATE TABLE Deposit (
    DeId INT IDENTITY(1,1) NOT NULL PRIMARY KEY,--Mã d?nh danh duy nh?t cho m?i l?n n?p ti?n.  	
    UserName NVARCHAR(50) NOT NULL,--Khóa ngo?i liên k?t v?i b?ng Account, xác d?nh ngu?i dùng dã n?p ti?n.
    [Money] INT NOT NULL,--S? ti?n dã n?p.
	[Status] INT NOT NULL--Tr?ng thái c?a l?n n?p ti?n (ví d?: thành công, dang ch? x? lý).
);

CREATE TABLE Blog (
	
	BlogID Int IDENTITY(1,1) NOT NULL Primary Key,
	Blog_Type NVARCHAR(200) not null,
	Blog_img NTEXT not null,
	Blog_img_tittle NTEXT not null,
	Blog_Tittle NVARCHAR(255) not null,
	Blog_Summary_Information NTEXT not null,
	Blog_Update_Time DATE not null,
	Blog_Detail NTEXT not null,
	Blog_Views int not null,
	Blog_Status NVARCHAR(55) not null,
	Blog_Flag int ,
	PersonID int not null,
	
	FOREIGN KEY (PersonID) REFERENCES  Person(PersonID)

);
CREATE TABLE Feedback (
    FeedbackID INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    CustomerID INT NOT NULL,                         -- Liên kết với người gửi feedback
    ProductID INT NOT NULL,                        -- Liên kết với sản phẩm
    RatedStar INT NOT NULL CHECK (RatedStar BETWEEN 1 AND 5),  -- Đánh giá sao (1-5)
    FeedbackContent NVARCHAR(MAX) NOT NULL, -- Nội dung feedback
    FeedbackReply NVARCHAR(MAX),
    ProcessedBy INT,   -- ID của người xử lý feedback (từ bảng Person)
    
    
    Status NVARCHAR(50) NOT NULL,  -- Trạng thái feedback (New, Resolved)
    CreatedDate DATETIME NOT NULL DEFAULT GETDATE(), -- Ngày tạo feedback
    ProcessedDate DATETIME,           -- Ngày xử lý

    
    FOREIGN KEY (CustomerID) REFERENCES Person(PersonID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID),
    FOREIGN KEY (ProcessedBy) REFERENCES Person(PersonID)

);
-- Bảng FeedbackDetails để lưu trữ hình ảnh và thông tin bổ sung
CREATE TABLE FeedbackDetails (
    FeedbackDetailID INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    FeedbackID INT NOT NULL,
    StoredFileName NVARCHAR(255),
    OriginalFileName NVARCHAR(255),
    FilePath NVARCHAR(500),
    FileType NVARCHAR(50),
    
    FOREIGN KEY (FeedbackID) REFERENCES Feedback(FeedbackID)
);



CREATE TABLE [dbo].[Setting](
	[ID] [int] identity(1,1) NOT NULL,
	[Type] [nvarchar](255) NOT NULL,
	[Value] [nvarchar](255) NOT NULL,
	[Order] [int] NOT NULL,
	[Status] [nvarchar](255) NOT NULL,
	[Image] [nvarchar](255) NULL
)
--drop table Cart
CREATE TABLE Cart (
    CartID INT PRIMARY KEY IDENTITY(1,1),
    PersonID INT NOT NULL,
    TotalPrice DECIMAL(18, 2) DEFAULT 0, -- Tổng giá trị của giỏ hàng
    FOREIGN KEY (PersonID) REFERENCES [Person](PersonID) -- Liên kết tới bảng User
);
--drop table CartItem
CREATE TABLE CartItem (
    CartItemID INT PRIMARY KEY IDENTITY(1,1),
    CartID INT NOT NULL,
    ProductID INT NOT NULL,
    Quantity INT NOT NULL, -- Số lượng sản phẩm
    Price DECIMAL(18, 2) NOT NULL, -- Giá sản phẩm tại thời điểm thêm vào giỏ
    TotalPrice AS (Quantity * Price), -- Tổng giá của sản phẩm trong giỏ
    FOREIGN KEY (CartID) REFERENCES Cart(CartID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);
--SELECT * FROM Cart WHERE PersonID = 3

-----------------------------------------------------------------------------------------------------
INSERT INTO Roles(RoleName)
Values
('customer'),
('makerting'),
('sale'),
('saleManager'),
('admin');

INSERT INTO Person (Name, Gender, DateOfBirth, StartDate,Email,RoleID,Password) 
VALUES 
(N'Nguyên Van Nam', N'Nam', '1980-01-01', '2022-12-12', 'vana@gmail.com',1,234),
(N'Nguyên Thị Bích', N'Nữ', '1990-02-02', '2023-08-06', 'thib@gmail.com',1,234),
(N'Trần Van Luơng', N'Nam', '1985-03-03', '2024-10-23', 'vanc@gmail.com',1,234),
(N'Phạm Quang Vu', N'Nam', '1975-04-04', '2010-01-01', 'vand@gmail.com',1,234),
(N'Lê Thanh Thúy', N'Nữ', '1988-05-05', '2012-02-02', 'thie@gmail.com',1,234),
(N'Đằng Nhật Thái', N'Nam', '2003-07-25', '2014-02-02', 'nam@gmail.com',2,234),
(N'Phan Đăng Quân', N'Nam', '2001-05-15', '2013-02-02', 'luu@gmail.com',2,234),
(N'Lê Thanh Thúy', N'Nữ', '1988-05-05', '2012-02-02', 'user',1,234),
(N'Đằng Nhật Nam', N'Nam', '2003-07-25', '2014-02-02', 'marketing',3,234),
(N'Phan Đăng Lưu', N'Nam', '2001-05-15', '2013-02-02', 'sale',3,234),
(N'Phan Đăng Hải', N'Nam', '2001-05-15', '2013-02-02', 'saleManager',4,234),
(N'Admin', N'Nam', '2001-05-15', '2013-02-02', 'admin',5,234);


Insert into ShowRoom(ShowRoomName,[Address]) Values
(N'Thành phố Hà Nội ',N'Số 123 Ðuờng 456 Quận Bắc Từ Liêm Thành Phố Hà Nội '),
(N'Thành phố Ðà Nẵng',N'Số 789 Ðuờng 101 Quận Liên Chiều Thành Phố Ðà Nẵng '),
(N'Thành phố Hồ Chí Minh',N'Số 102 Ðuờng 1013 Quận Gò Vấp Thành Phố Hồ Chí Minh ');


Insert into Wallets(PersonID,Balance) Values
(2,0),
(3,0);


Insert into Categories(CategoryName,Description) Values
('Phone-Tablet',null),
('Laptop',null),
('PC',null),
('Monitor',null),
('Earphone',null);
------------------------------------------------------------------------------------------------------------------------------

INSERT INTO Products (title, ProductName, [Views], [releaseDate], [QuantitySold], [CategoryID], Quantity, Sale, img, price, publisher, sortDescription, [description], [status],brand) VALUES
(N'Title 3', N'iPhone 15 128GB | Chính hãng VN/A', 1300, '2024-01-03', 53, 1, 103, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/i/p/iphone-15-plus_1__1.png', 13000, 'Publisher 3', NULL, NULL, 'Available','Apple'),
(N'Title 4', N'iPhone 15 Pro 128GB | Chính hãng VN/A', 1400, '2024-01-04', 54, 1, 104, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/i/p/iphone-15-pro-max_4.png', 14000, 'Publisher 4', NULL, NULL, 'Available','Apple'),
(N'Title 5', N'iPhone 14 Pro 128GB | Chính hãng VN/A', 1500, '2024-01-05', 55, 1, 105, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/i/p/iphone-14-pro_2__4.png', 15000, 'Publisher 5', NULL, NULL, 'Available','Apple'),
(N'Title 6', N'iPhone 11 64GB | Chính hãng VN/A', 1600, '2024-01-06', 56, 1, 106, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/4/_/4_187.jpg', 16000, 'Publisher 6', NULL, NULL, 'Available','Apple'),
(N'Title 7', N'Xiaomi POCO X6 Pro 5G 8GB 256GB', 1700, '2024-01-07', 57, 1, 107, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/t/_/t_i_xu_ng_22__6.png', 17000, 'Publisher 7', NULL, NULL, 'Available','Xiaomi'),
(N'Title 8', N'Xiaomi Redmi Note 13 Pro 4G', 1800, '2024-01-08', 58, 1, 108, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/x/i/xiaomi-redmi-note-13-pro-4g_13__1.png', 18000, 'Publisher 8', NULL, NULL, 'Available','Xiaomi'),
(N'Title 9', N'Xiaomi Redmi Note 13 (6GB 128GB)', 1900, '2024-01-09', 59, 1, 109, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/x/i/xiaomi-redmi-note-13_1__1_1.png', 19000, 'Publisher 9', NULL, NULL, 'Available','Xiaomi'),
(N'Title 10', N'Xiaomi 14 Ultra 5G (16GB 512GB)', 2000, '2024-01-10', 60, 1, 110, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/x/i/xiaomi-14-ultra.jpg', 20000, 'Publisher 10', NULL, NULL, 'Available','Xiaomi'),
(N'Title 11', N'Samsung Galaxy S23 Ultra 256GB', 2100, '2024-01-11', 61, 1, 111, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/s/2/s23-ultra-tim.png', 21000, 'Publisher 11', NULL, NULL, 'Available','Samsung'),
(N'Title 12', N'Samsung Galaxy Z Flip5 512GB', 2200, '2024-01-12', 62, 1, 112, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/s/a/samsung-galaxy-z-flip5-tim-4.jpg', 22000, 'Publisher 12', NULL, NULL, 'Available','Samsung'),
(N'Title 13', N'Samsung Galaxy A54 5G 128GB', 2300, '2024-01-13', 63, 1, 113, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/s/a/samsung-galaxy-a54_1_.jpg', 23000, 'Publisher 13', NULL, NULL, 'Available','Samsung'),
(N'Title 14', N'Oppo Reno8 Pro 5G 256GB', 2400, '2024-01-14', 64, 1, 114, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/o/p/oppo_reno8_pro_1_.jpg', 24000, 'Publisher 14', NULL, NULL, 'Available','Oppo'),
(N'Title 15', N'Oppo Find N3 Flip 512GB', 2500, '2024-01-15', 65, 1, 115, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/o/p/oppo-find-n3-flip_2_.png', 25000, 'Publisher 15', NULL, NULL, 'Available','Oppo'),

------------------------------------------------------------------------------------------------------------------------
(N'Title 16', N'Laptop gaming Acer Predator Helios 300 PH315 55 76KG', 2600, '2024-01-16', 66, 2, 116, 10, 'https://product.hstatic.net/200000722513/product/76kg_1433e407838944df88bd906b57729c0a_1024x1024.png', 26000, 'Publisher 16', NULL, NULL, 'Available','Acer'),
(N'Title 17', N'Laptop gaming Lenovo LOQ 15IAX9 83GS001QVN', 2700, '2024-01-17', 67, 2, 117, 10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJixy1uhvUS4wSs7SAIaApQjxeJeQQIrvYxQ&s', 27000, 'Publisher 17', NULL, NULL, 'Available','Lenovo'),
(N'Title 18', N'Laptop gaming Acer Nitro V ANV15 51 57B2', 2800, '2024-01-18', 68, 2, 118, 10, 'https://product.hstatic.net/200000837185/product/acer-gaming-nitro-v-2023-3_11c2042c95124816886f05ec5941aa38_master.jpg', 28000, 'Publisher 18', NULL, NULL, 'Available','Acer'),
(N'Title 19', N'Laptop gaming ASUS ROG Zephyrus G14 GA403UV QS170W', 2900, '2024-01-19', 69, 2, 119, 10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhkn84UbPK-vIOPWIj1F5HuQur-b-WT0ZGaw&s', 29000, 'Publisher 19', NULL, NULL, 'Available','ASUS'),
(N'Title 20', N'Laptop gaming MSI Katana 15 B13VEK 252VN', 3000, '2024-01-20', 70, 2, 120, 10, 'https://product.hstatic.net/200000722513/product/1205vn_da651643e91047bfa9729c53f93ffc6e_large_39f1561f3448481c94add35d7fda7dc4.png', 30000, 'Publisher 20', NULL, NULL, 'Available','MSI'),
(N'Title 21', N'Laptop gaming Gigabyte G5 KF E3VN333SH', 3100, '2024-01-21', 71, 2, 121, 10, 'https://anphat.com.vn/media/product/45085_laptop_gigabyte_g5_kf_e3vn333sh_anphatpc6.jpg', 31000, 'Publisher 21', NULL, NULL, 'Available','Gigabyte'),
(N'Title 22', N'Laptop gaming Dell G15 5530 i9H161W11GR4060', 3200, '2024-01-22', 72, 2, 122, 10, 'https://product.hstatic.net/200000722513/product/ava_3bcf0035952f41a2847797845ef41b81_1024x1024.png', 32000, 'Publisher 22', NULL, NULL, 'Available','DELL'),
(N'Title 23', N'Laptop gaming Dell G15 5525 R7H165W11GR3060', 3300, '2024-01-23', 73, 2, 123, 10, 'https://laptopworld.vn/media/product/13236_dell_gaming_g15_5525_2.jpg', 33000, 'Publisher 23', NULL, NULL, 'Available','DELL'),
(N'Title 24', N'Laptop gaming Lenovo LOQ 15ARP9 83JC003YVN', 3400, '2024-01-24', 74, 2, 124, 10, 'https://product.hstatic.net/200000722513/product/ava-trang_96d26f2b6f5443e78f5ef21b5c6a6b7e_1024x1024.png', 34000, 'Publisher 24', NULL, NULL, 'Available','Lenovo'),
(N'Title 25', N'Laptop gaming ASUS ROG Strix SCAR 15 G533ZW LN134W', 3500, '2024-01-25', 75, 2, 125, 10, 'https://laptopworld.vn/media/product/10792_asus_rog_strix_scar_15_g533zm_3.jpg', 35000, 'Publisher 25', NULL, NULL, 'Available','Asus'),
(N'Title 26', N'Laptop ASUS Zenbook 14 OLED UM3402YA KM405W', 3600, '2024-01-26', 76, 2, 126, 10, 'https://product.hstatic.net/200000722513/product/um3402ya-km405w_76e67c0074d744718702784cd113f4aa_1024x1024.png', 36000, 'Publisher 26', NULL, NULL, 'Available','Asus'),
(N'Title 27', N'Laptop ASUS Zenbook 14 OLED UX3402VA KM203W', 3700, '2024-01-27', 77, 2, 127, 10, 'https://cdn2.fptshop.com.vn/unsafe/1920x0/filters:quality(100)/2023_3_24_638152793095056758_asus-zenbook-ux3402-bac-dd.jpg', 37000, 'Publisher 27', NULL, NULL, 'Available','Asus'),
(N'Title 28', N'Gigabyte AORUS 5 KE4 72VN314SH', 3800, '2024-01-28', 78, 2, 128, 10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQq3qLqi52s7fAFU9gdf69rLXOiBqyaWPdQdg&s', 38000, 'Publisher 28', NULL, NULL, 'Available','Gigabyte'),
(N'Title 29', N'Gigabyte G5 MF F2VN333SH', 3900, '2024-01-29', 79, 2, 129, 10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQq3qLqi52s7fAFU9gdf69rLXOiBqyaWPdQdg&s', 39000, 'Publisher 29', NULL, NULL, 'Available','Gigabyte'),
(N'Title 30', N'Dell Vostro 3530 V5I3465W1', 4000, '2024-01-30', 80, 2, 130, 10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQq3qLqi52s7fAFU9gdf69rLXOiBqyaWPdQdg&s', 40000, 'Publisher 30', NULL, NULL, 'Available','DELL'),
(N'Title 31', N'Dell Inspiron 15 N3530 I3U085W11BLU', 4100, '2024-01-31', 81, 2, 131, 10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQq3qLqi52s7fAFU9gdf69rLXOiBqyaWPdQdg&s', 41000, 'Publisher 31', NULL, NULL, 'Available','DELL'),
(N'Title 32', N'Lenovo V14 G4 IRU 83A000BHVN', 4200, '2024-02-01', 82, 2, 132, 10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQq3qLqi52s7fAFU9gdf69rLXOiBqyaWPdQdg&s', 42000, 'Publisher 32', NULL, NULL, 'Available','Lenovo'),
(N'Title 33', N'Lenovo ThinkBook 14 G6 IRL 21KG00RDVN', 4300, '2024-02-02', 83, 2, 133, 10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQq3qLqi52s7fAFU9gdf69rLXOiBqyaWPdQdg&s', 43000, 'Publisher 33', NULL, NULL, 'Available','Lenovo'),
(N'Title 34', N'Acer Aspire 5 A515 58GM 598J', 4400, '2024-02-03', 84, 2, 134, 10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQq3qLqi52s7fAFU9gdf69rLXOiBqyaWPdQdg&s', 44000, 'Publisher 34', NULL, NULL, 'Available','Acer'),
(N'Title 35', N'Acer Aspire 5 A514 56P 55K5', 4500, '2024-02-04', 85, 2, 135, 10, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQq3qLqi52s7fAFU9gdf69rLXOiBqyaWPdQdg&s', 45000, 'Publisher 35', NULL, NULL, 'Available','Acer'),
---------------------------------------------------------------------------------------------------------

(N'Title 36', N'Máy tính để bàn đồng bộ Dell OptiPlex 7010 SFF (i3-12100| 8GB | 512GB SSD | KB_M | WinHome11| 1Yr )', 4600, '2024-02-05', 86, 3, 136, 10, 'https://anphat.com.vn/media/product/49607_52946_may_tinh_de_ban_dell_optiplex_7010sff.jpg', 46000, 'Publisher 36', NULL, NULL, 'Available','DELL'),
(N'Title 37', N'PC Intel® NUC 12 Pro Kit L6 RNUC12WSHI70001 99AP2L (i7-1260P / WiFi 802.11ax / OS / 3yr)', 4700, '2024-02-06', 87, 3, 137, 10, 'https://anphat.com.vn/media/product/49726_rnuc11pahi70z00_nuc_intel.jpg', 47000, 'Publisher 37', NULL, NULL, 'Available','Intel'),
(N'Title 38', N'Máy tính trạm Workstation Dell Precision 3660 Tower 71042197', 4800, '2024-02-07', 88, 3, 138, 10, 'https://anphat.com.vn/media/product/49355_50881_dell_precision_3660_tower__a1.jpg', 48000, 'Publisher 38', NULL, NULL, 'Available','DELL'),
(N'Title 39', N'Máy tính để bàn đồng bộ Asus D500MD-512400027W (i5-12400/4GB/256GB SSD/UMA/ax+BT/KB/M/Win 11/Đen/2YW)', 4900, '2024-02-08', 89, 3, 139, 10, 'https://anphat.com.vn/media/product/46606_52709_may_tinh_de_ban_asus_d500md_1.jpg', 49000, 'Publisher 39', NULL, NULL, 'Available','Asus'),
(N'Title 40', N'Máy tính trạm Lenovo ThinkStation P3 Tower 30GS005AVA ', 5000, '2024-02-09', 90, 3, 140, 10, 'https://anphat.com.vn/media/product/47873_24070_30gs005ava.jpeg', 50000, 'Publisher 40', NULL, NULL, 'Available','Lenovo'),
(N'Title 41', N'Máy tính để bàn đồng bộ Dell OptiPlex 7010 SFF ', 5100, '2024-02-10', 91, 3, 141, 10, 'https://anphat.com.vn/media/product/47360_52897_may_tinh_de_ban_dell_optiplex_7010sff_1.jpg', 51000, 'Publisher 41', NULL, NULL, 'Available','DELL'),
(N'Title 42', N'Máy tính để bàn All in one Lenovo ThinkCentre neo 50a 24 Gen5 12SC0024VA', 5200, '2024-02-11', 92, 3, 142, 10, 'https://anphat.com.vn/media/product/46060_dell_optiplex_7010_sff_front_left.jpg', 52000, 'Publisher 42', NULL, NULL, 'Available','Lenovo'),
(N'Title 43', N'Máy tính để bàn All In One Asus A3202WBAK-WPB018W ', 5300, '2024-02-12', 93, 3, 143, 10, 'https://anphat.com.vn/media/product/49766_m__y_t__nh_______b__n_all_in_one_lenovo_thinkcentre_neo_50a_24_gen5_12sc0024va__3_.jpg', 53000, 'Publisher 43', NULL, NULL, 'Available','Asus'),
(N'Title 44', N'Máy tính để bàn All in one Lenovo ThinkCentre neo 50a 24 Gen5 12SC0025VA', 5400, '2024-02-13', 94, 3, 144, 10, 'https://anphat.com.vn/media/product/49260_m__y_t__nh_______b__n_all_in_one_asus_a3202wbak_wpb018w__1_.jpg', 54000, 'Publisher 44', NULL, NULL, 'Available','Lenovo'),
(N'Title 45', N'Máy tính để bàn All in one Asus A3402WBAK-WPC048W', 5500, '2024-02-14', 95, 3, 145, 10, 'https://anphat.com.vn/media/product/49767_m__y_t__nh_______b__n_all_in_one_lenovo_thinkcentre_neo_50a_24_gen5_12sc0025va__4_.jpg
', 55000, 'Publisher 45', NULL, NULL, 'Available','Asus'),
(N'Title 46', N'Máy tính để bàn All In One Asus A3402WBAT-WA187W', 5600, '2024-02-15', 96, 3, 146, 10, 'https://anphat.com.vn/media/product/49070_m__y_t__nh_______b__n_all_in_one_asus_a3402wbak_wpc048w__1_.jpg', 56000, 'Publisher 46', NULL, NULL, 'Available','Asus'),
(N'Title 47', N'Máy tình để bàn đồng bộ HP Pro Mini 260 G9 - 9H092PT', 5700, '2024-02-16', 97, 3, 147, 10, 'https://anphat.com.vn/media/product/46160_all_in_one_asus_a3402wbat_wa187w_anphat88.jpg', 57000, 'Publisher 47', NULL, NULL, 'Available','HP'),
(N'Title 48', N'Máy tính trạm Workstation Dell Precision 5860', 5800, '2024-02-17', 98, 3, 148, 10, 'https://laptopxachtay.com.vn/Images/Products/41117_41098_40611_40424_dell-precision-3630-xeon-e-2124g-8g-1tb-quadpro-p620-2gb-dos_39575_1.jpg?', 58000, 'Publisher 48', NULL, NULL, 'Available','DELL'),
(N'Title 49', N'Máy tính để bàn đồng bộ Dell Vostro 3020 MT MTI72062W1-8G-512G', 5900, '2024-02-18', 99, 3, 149, 10, 'https://mega.com.vn/media/product/8181_570x470_dell_vostro_3670_2_3_1_3_d.jpg', 59000, 'Publisher 49', NULL, NULL, 'Available','DELL'),
(N'Title 50', N'Máy tính để bàn All in one Lenovo ThinkCentre neo 50a 27 Gen5 12SA001HVA ', 6000, '2024-02-19', 100, 3, 150, 10, 'https://anphat.com.vn/media/lib/15-07-2024/lenovo-thinkcentre-neo-50a-27-gen-5-12sa001hva.jpg', 60000, 'Publisher 50', NULL, NULL, 'Available','Lenovo'),
(N'Title 51', N'Máy tính trạm Workstation Dell Precision 3660 Tower - 42PT3660D20 ', 6100, '2024-02-20', 101, 3, 151, 10, 'https://kenhtinhoc.vn/wp-content/uploads/2022/02/pc-gaming-g480-kenh-tin-hoc-core-i5-10400f-16gb-180gb-ssd-1tb-hdd-rtx3060-ti-8gb-1.jpg', 61000, 'Publisher 51', NULL, NULL, 'Available','DELL'),
(N'Title 52', N'Máy tính để bàn All in one Lenovo ThinkCentre neo 30a 27 Gen 4 12JU001GVN', 6200, '2024-02-21', 102, 3, 152, 10, 'https://minhancomputercdn.com/media/product/4727_pc_gaming_i7_10700__gtx_1650__ram_16gb__ssd_250gb.jpg', 62000, 'Publisher 52', NULL, NULL, 'Available','Lenovo'),
(N'Title 53', N'Máy tính để bàn đồng bộ Dell OptiPlex 7010 Tower ', 6300, '2024-02-22', 103, 3, 153, 10, 'https://macstores.vn/tin-tuc/wp-content/uploads/2020/04/pc-la-gi-1.jpg', 63000, 'Publisher 53', NULL, NULL, 'Available','DELL'),
(N'Title 54', N'Máy tính để bàn đồng bộ HP Slim Desktop S01-pF2035d 6L6W5PA', 6400, '2024-02-23', 104, 3, 154, 10, 'https://static.cybertron.com/clx/home/pcs-laps-section/custom-gaming-pcs.jpg', 64000, 'Publisher 54', NULL, NULL, 'Available','HP'),
(N'Title 55', N'PC Intel ASUS NUC 11 Essential L6 BNUC11ATKPE0000', 6500, '2024-02-24', 105, 3, 155, 10, 'https://i0.wp.com/blog.giotech.net/wp-content/uploads/2017/03/casepcgaming_2.jpg?resize=610%2C449', 65000, 'Publisher 55', NULL, NULL, 'Available','Asus'),
(N'Title 56', N'Mini PC Asus Intel NUC 12 Pro Tall', 6600, '2024-02-25', 106, 3, 156, 10, 'https://res.cloudinary.com/jawa/image/upload/f_auto,ar_1:1,c_fill,w_3840,q_auto/production/listings/fyztjpw57wswkcisnuw4', 66000, 'Publisher 56', NULL, NULL, 'Available','Intel'),
(N'Title 57', N'Mini PC Asus Intel NUC 12 Pro Tall', 6700, '2024-02-26', 107, 3, 157, 10, 'https://images-na.ssl-images-amazon.com/images/I/71jELtZLEwL.jpg', 67000, 'Publisher 57', NULL, NULL, 'Available','Intel'),
(N'Title 58', N'Máy tính để bàn đồng bộ Dell OptiPlex 7010TGW', 6800, '2024-02-27', 108, 3, 158, 10, 'https://in.norton.com/content/dam/norton/backgrounds/image_male_gamer_pc_mobile_2x.jpg', 68000, 'Publisher 58', NULL, NULL, 'Available','DELL'),
(N'Title 59', N'Máy tính để bàn đồng bộ Dell OptiPlex 7010 SFF', 6900, '2024-02-28', 109, 3, 159, 10, 'https://media.cnn.com/api/v1/images/stellar/prod/210910130214-gaming-pcs.jpg?q=w_1600,h_900,x_0,y_0,c_fill', 69000, 'Publisher 59', NULL, NULL, 'Available','DELL'),
(N'Title 60', N'Máy tính để bàn đồng bộ HP Pro Mini 400 G9 _ 9H1U6PT', 7000, '2024-02-29', 110, 3, 160, 10, 'https://m.media-amazon.com/images/I/61MUGDcdM-L.jpg', 70000, 'Publisher 60', NULL, NULL, 'Available','HP'),

-------------------------------------------------------------------------------------

(N'Title 62', N'Màn hình Samsung LS24R350FZEXXV 23.8', 7200, '2024-03-02', 112, 4, 162, 10, 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/a/man-hinh-di-dong-asus-zenscreen-mb166cr-15-6-inch_4_.png', 72000, 'Publisher 62', NULL, NULL, 'Available','Samsung'),
(N'Title 63', N'Màn hình MSI MP253 25 inch', 7300, '2024-03-03', 113, 4, 163, 10, 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/a/man-hinh-samsung-ls34c500gaexxv-34-inch.png', 73000, 'Publisher 63', NULL, NULL, 'Available','MSI'),
(N'Title 64', N'Màn hình thông minh Samsung LS32BM700UEXXV 32 inch', 7400, '2024-03-04', 114, 4, 164, 10, 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/f/r/frame_195_4_.jpg', 74000, 'Publisher 64', NULL, NULL, 'Available','Samsung'),
(N'Title 65', N'Màn hình Gaming ASUS TUF VG249Q3A 24 inch', 7500, '2024-03-05', 115, 4, 165, 10, 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/a/man-hinh-di-dong-msi-pro-mp161-e2-15-6-inch_1_.jpg', 75000, 'Publisher 65', NULL, NULL, 'Available','Asus'),
(N'Title 66', N'Màn hình Samsung LS24C330GAEXXV 24 inch', 7600, '2024-03-06', 116, 4, 166, 10, 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/1/_/1_75_29.jpg', 76000, 'Publisher 66', NULL, NULL, 'Available','Samsung'),
(N'Title 67', N'Màn hình Gaming LG UltraGear 24GN65R 24 inch', 7700, '2024-03-07', 117, 4, 167, 10, 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_179_1__1.png', 77000, 'Publisher 67', NULL, NULL, 'Available','LG'),
(N'Title 68', N'Màn hình Gaming E-Dra EGM22F75P 22 inch', 7800, '2024-03-08', 118, 4, 168, 10, 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_238_1_3.png', 78000, 'Publisher 68', NULL, NULL, 'Available','E-Dra'),
(N'Title 69', N'Màn hình LG 27 inch 27UP600', 7900, '2024-03-09', 119, 4, 169, 10, 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_238_1_3.png', 79000, 'Publisher 69', NULL, NULL, 'Available','LG'),
(N'Title 70', N'Màn hình Gaming E-DRA EGM27F100 27 inch', 8000, '2024-03-10', 120, 4, 170, 10, 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/a/man-hinh-gaming-asus-tuf-vg249q3a-24-inch.png', 80000, 'Publisher 70', NULL, NULL, 'Available','E-Dra'),
(N'Title 71', N'Màn hình Gaming ViewSonic VX2479 HD PRO 180HZ 24 inch', 8100, '2024-03-11', 121, 4, 171, 10, 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/a/man-hinh-samsung-ls24c330gaexxv-24-inch.png', 81000, 'Publisher 71', NULL, NULL, 'Available','Viewsonic'),
(N'Title 72', N'Màn hình MSI Pro MP245V 23.8 inch', 8200, '2024-03-12', 122, 4, 172, 10, 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/g/r/group_257_2__1.png', 82000, 'Publisher 72', NULL, NULL, 'Available','MSI'),
(N'Title 73', N'Màn hình Gaming E-Dra EGM25F100 25 inch', 8300, '2024-03-13', 123, 4, 173, 10, 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/a/man-hinh-gaming-e-dra-egm22f75p-22-inch.png', 83000, 'Publisher 73', NULL, NULL, 'Available','E-Dra'),
(N'Title 74', N'Màn hình Samsung Gaming Odyssey G5 LC34G55TWWEXXV 34 inch', 8400, '2024-03-14', 124, 4, 174, 10, 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/5/_/5_36_21.jpg', 84000, 'Publisher 74', NULL, NULL, 'Available','LG'),
(N'Title 75', N'Màn hình Monitor Xiaomi 27 inch A27i ELA5345EU', 8500, '2024-03-15', 125, 4, 175, 10, 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/m/a/man-hinh-gaming-e-dra-egm27f100-27-inch.png', 85000, 'Publisher 75', NULL, NULL, 'Available','Xiaomi'),

-----------------------------------------------------------------------------------------------------------------------------
(N'Title 82', N'Tai nghe Bluetooth True Wireless HUAWEI', 9200, '2024-03-22', 132, 5, 182, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/t/a/tai-nghe-khong-day-huawei-freeclip-.png', 92000, 'Publisher 82', NULL, NULL, 'Available','Huawei'),
(N'Title 83', N'Tai nghe Apple EarPods USB-C MTJY3ZA/A', 9300, '2024-03-23', 133, 5, 183, 10, 'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/a/tai-nghe-apple-earpods-usb-c_1_.png', 93000, 'Publisher 83', NULL, NULL, 'Available','Apple'),
(N'Title 84', N'Tai nghe Bluetooth Apple AirPods Pro 2 2023 USB-C', 9400, '2024-03-24', 134, 5, 184, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/t/a/tai-nghe-khong-day-huawei-freeclip-.png', 94000, 'Publisher 84', NULL, NULL, 'Available','Apple'),
(N'Title 85', N'Tai nghe Bluetooth chụp tai Sony WH-CH520', 9500, '2024-03-25', 135, 5, 185, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/t/a/tai-nghe-chup-tai-sony-wh-ch520-_2_.png', 95000, 'Publisher 85', NULL, NULL, 'Available','Sony'),
(N'Title 86', N'Tai nghe Bluetooth chụp tai Baseus Bass 35 Max', 9600, '2024-03-26', 136, 5, 186, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/t/a/tai-nghe-chup-tai-baseus-bass-35-max_3_.png', 96000, 'Publisher 86', NULL, NULL, 'Available','Baseus'),
(N'Title 87', N'Tai nghe Bluetooth True Wireless Xiaomi Redmi Buds 6 Active', 9700, '2024-03-27', 137, 5, 187, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/t/a/tai-nghe-bluetooth-xiaomi-redmi-buds-6-active_1_.png', 97000, 'Publisher 87', NULL, NULL, 'Available','Xiaomi'),
(N'Title 88', N'Tai nghe có dây JBL Tune 310C', 9800, '2024-03-28', 138, 5, 188, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/t/a/tai-nghe-jbl-tune-310c-3.png', 98000, 'Publisher 88', NULL, NULL, 'Available','JBL'),
(N'Title 89', N'Tai nghe KZ ZSN Pro X', 9900, '2024-03-29', 139, 5, 189, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/k/z/kz_zsn_pro_x_1.png', 99000, 'Publisher 89', NULL, NULL, 'Available','KZ'),
(N'Title 90', N'Tai nghe có dây Gaming Havit H2015E', 10000, '2024-03-30', 140, 5, 190, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/t/a/tai-nghe-co-day-havit-h2015e_6_.png', 100000, 'Publisher 90', NULL, NULL, 'Available','Havit'),
(N'Title 91', N'TAI NGHE APPLE EARPODS CỔNG LIGHTNING CHÍNH HÃNG', 10100, '2024-03-31', 141, 5, 191, 10, 'https://cdn2.cellphones.com.vn/x/media/catalog/product/f/r/frame_3_3.png', 101000, 'Publisher 91', NULL, NULL, 'Available','Apple');

-----------------------------------------------------------------------------------------------



insert into ShowRoomDetail(ShowRoomID,ProductID)
values
(1,1),(2,2);

------------------------------------------------------------------------------------------------------------------------------


---------------------------------------------Gift-----------------------------------------------------------------


Insert into [dbo].[Gift](GiftName,Quantity,[image]) values
	(N'Túi đựng laptop',50,N'gitimg/git1.jpg'),
	(N'Bình dữ nhiệt',50,N'gitimg/git2.jpg'),
	(N'Quạt điện cơ x19',50,N'gitimg/git3.jpg'),
	(N'Chảo chống dính',50,N'gitimg/git4.jpg'),
	(N'Nước lọc lavie',50,N'gitimg/git5.jpg');
-------------------------------------------- Product Attributes ----------------------------------
INSERT INTO ProductAttributes (ProductID, AttributeName, AttributeValue)
VALUES 
(1, 'RAM', '6GB'),
(1, 'ScreenSize', '6.1 inch'),
(1, 'Battery', '3279mAh'),
(1, 'ScreenResolution', '1170 x 2532 pixels'),
(1, 'Chipset', 'A15 Bionic'),
(1, 'RearCamera', '12MP dual'),
(1, 'FrontCamera', '12MP'),
(1, 'OperatingSystem', 'iOS 16'),
--
(2, 'RAM', '6GB'),
(2, 'ScreenSize', '6.1 inch'),
(2, 'Battery', '3279mAh'),
(2, 'ScreenResolution', '1170 x 2532 pixels'),
(2, 'Chipset', 'A15 Bionic'),
(2, 'RearCamera', '12MP dual'),
(2, 'FrontCamera', '12MP'),
(2, 'OperatingSystem', 'iOS 16'),
--
(3, 'RAM', '6GB'),
(3, 'ScreenSize', '6.1 inch'),
(3, 'Battery', '3279mAh'),
(3, 'ScreenResolution', '1170 x 2532 pixels'),
(3, 'Chipset', 'A15 Bionic'),
(3, 'RearCamera', '12MP dual'),
(3, 'FrontCamera', '12MP'),
(3, 'OperatingSystem', 'iOS 16'),
--
(4, 'RAM', '6GB'),
(4, 'ScreenSize', '6.1 inch'),
(4, 'Battery', '3279mAh'),
(4, 'ScreenResolution', '1170 x 2532 pixels'),
(4, 'Chipset', 'A15 Bionic'),
(4, 'RearCamera', '12MP dual'),
(4, 'FrontCamera', '12MP'),
(4, 'OperatingSystem', 'iOS 16'),
--
(5, 'RAM', '6GB'),
(5, 'ScreenSize', '6.1 inch'),
(5, 'Battery', '3279mAh'),
(5, 'ScreenResolution', '1170 x 2532 pixels'),
(5, 'Chipset', 'A15 Bionic'),
(5, 'RearCamera', '12MP dual'),
(5, 'FrontCamera', '12MP'),
(5, 'OperatingSystem', 'iOS 16');
----------------------------------------- Orders -------------------------------------------------------------
insert into Orders(OrderDate,PersonID,ShowRoomID,Method,SaleID,Status,ShipStatus,SaleNote,receivedDate)
values
(2024-09-14,1,1, N'Tiền mặt', 8, N'Complete',N'đã xuất kho',N'Must be complete fast',DATEADD(day, 1, GETDATE())),
(2024-09-14,1,1, N'Tiền mặt', 9, N'In Progress',N'đang giao hàng',N'Must be complete fast' ,DATEADD(day, 2, GETDATE())),
(2024-09-14,2,2, N'Tiền mặt', 10, N'In Progress',N'đã giao hàng',N'Must be complete fast',DATEADD(day, 2, GETDATE())),
(2024-09-15,2,3, N'Tiền mặt', Null, N'In Line',Null, N'Must be complete fast',null),
(2024-09-15,1,2, N'Tiền mặt', Null, N'In Line',Null,N'Must be complete fast',null),
(2024-09-15,3,1, N'Tiền mặt', null, N'In Line',Null,N'Must be complete fast', null),
(2024-09-13,3,1, N'Tiền mặt', 8, N'Complete',N'đã xuất kho',N'Must be complete fast',DATEADD(day, 3, GETDATE())),
(2024-09-13,4,3, N'Tiền mặt', 9, N'Complete',N'đã giao hàng',N'Must be complete fast',DATEADD(day, 3, GETDATE())),
(2024-09-13,4,2, N'Tiền mặt', 10, N'Complete',N'đã nhận hàng',N'Must be complete fast',DATEADD(day, 2, GETDATE())),
(2024-09-13,3,3, N'Tiền mặt', 8, N'Complete',N'đang giao hàng',N'Must be complete fast',DATEADD(day, 2, GETDATE())),
(2024-09-15,5,1, N'Tiền mặt', null, N'In Line',Null,N'Must be complete fast',null),
(2024-09-14,2,2, N'Tiền mặt', 9, N'In Progress',null,N'Must be complete fast',DATEADD(day, 2, GETDATE()));

------------------------------------------OrderDetails----------------------------------------------------------
insert into OrderDetails(OrderID,ProductID,GiftID,Quantity, UnitPrice, TotalCost)
values
(1,1,2,1,19690000,19690000), 
(1,2,2,2,25590000,51180000),
(2,3,2,1,18390000,18390000), 
(3,1,2,1,19690000,19690000), 
(3,2,2,2,25590000,51180000),
(4,3,2,1,18390000,18390000),
(5,16,2,1,23990000,23990000),
(5,17,2,1,54990000,54990000),
(6,30,1,1,14290000,14290000),
(6,41,2,1,12990000,12990000),
(6,63,3,1,2289000,2289000),
(7,82,1,1,540000,540000),
(7,64,2,1,3590000,3590000),
(7,49,3,1,28490000,28490000),
(7,10,4,1,16490000,16490000),
(8,79,2,1,590000,590000),
(9,82,4,1,540000,540000),
(10,27,1,1,19990000,19990000),
(11,15,3,1,21590000,21590000),
(12,40,2,1,14290000,14290000);




 --------------------------------------------- Blog ----------------------------------------
 /*
quốc tế phụ nữ: 8/3 --> 1/3 -> 8/3
quốc khánh : 2/9 --> 31/8 - 3/9
lễ giáng sinh : 25/12 -->20/12
quốc tế nam giới 19-11 --> 15/11 -> 19/11
quốc tế thiếu nhi : 1 - 6 --> 30/6 - > 2/6
*/
Insert into Blog(Blog_img,Blog_img_tittle,Blog_Type,Blog_Tittle,Blog_Summary_Information,Blog_Update_Time,Blog_Detail,Blog_Views,Blog_Status,Blog_Flag,PersonID)
Values('https://blog.thebigphonestore.co.uk/wp-content/uploads/2024/05/Blog-Image-Presentation-169-22-1024x576.png',N'Hình ảnh mang tính chất minh họa',N'Smart Phone',N'Những Điểm Cần Lưu Ý Khi Mua Điện Thoại Mới',
N'Mua điện thoại mới có thể là một quyết định khó khăn, đặc biệt với những ai chưa có kinh nghiệm. Bài viết này sẽ giúp bạn lựa chọn được chiếc điện thoại phù hợp nhất.',
'2023-09-27',N'Mua một chiếc điện thoại mới có thể là một thách thức với quá nhiều sự lựa chọn trên thị trường. Dưới đây là một số điểm cần lưu ý giúp bạn chọn được chiếc điện thoại phù hợp nhất:

Hiệu năng và Bộ vi xử lý:
Hãy kiểm tra bộ vi xử lý của điện thoại vì nó quyết định tốc độ và khả năng xử lý các tác vụ. Các dòng chip mới nhất từ Apple, Qualcomm, và MediaTek đều mang lại hiệu năng tốt.

Camera:
Chất lượng camera đang là yếu tố quan trọng với nhiều người dùng. Hãy chọn điện thoại có camera chất lượng tốt nếu bạn yêu thích chụp ảnh và quay video.

Dung lượng pin:
Dung lượng pin và khả năng sạc nhanh là những yếu tố bạn cần quan tâm, đặc biệt nếu bạn là người dùng điện thoại nhiều trong ngày.

Hệ điều hành:
Hãy cân nhắc giữa iOS và Android, vì mỗi hệ điều hành có những ưu điểm và nhược điểm riêng. iOS mang lại sự ổn định và bảo mật cao, trong khi Android cho phép tùy biến và có nhiều lựa chọn hơn.

Giá cả:
Xác định ngân sách trước khi mua và so sánh các dòng sản phẩm trong cùng phân khúc để chọn được điện thoại phù hợp với túi tiền.',150,'Published',0,2),
('https://gcs.tripi.vn/public-tripi/tripi-feed/img/476108Iyx/anh-mo-ta.png',N'Hình ảnh tốp 5 điện thoại','Smart Phone',N'Top 5 Điện Thoại Thông Minh Nổi Bật Năm 2024',N'Năm 2024 đánh dấu sự xuất hiện của nhiều mẫu điện thoại thông minh với những cải tiến vượt bậc về công nghệ và thiết kế.',
'2024-03-03',N'Năm 2024 là năm bùng nổ của các dòng điện thoại thông minh với nhiều cải tiến vượt trội. Dưới đây là danh sách 5 chiếc điện thoại đáng chú ý nhất:

iPhone 15 Pro Max
iPhone 15 Pro Max nổi bật với thiết kế sang trọng, màn hình Super Retina XDR, và bộ xử lý A18 Bionic mạnh mẽ. Camera nâng cấp với khả năng chụp đêm xuất sắc và quay video 8K.

Samsung Galaxy S24 Ultra
Samsung Galaxy S24 Ultra sở hữu màn hình Dynamic AMOLED 2X với độ phân giải cao, hỗ trợ bút S Pen. Camera zoom quang học 200x, tích hợp AI mạnh mẽ, và pin dung lượng lớn.

Google Pixel 8 Pro
Google Pixel 8 Pro tiếp tục duy trì thế mạnh với khả năng chụp ảnh và xử lý hình ảnh tuyệt vời nhờ chip Tensor G3. Chế độ chụp ban đêm và xử lý ảnh AI nâng cao mang lại những bức hình chất lượng cao.

OnePlus 12
OnePlus 12 với thiết kế viền siêu mỏng, màn hình 120Hz mượt mà, và bộ sạc nhanh 150W giúp sạc đầy pin chỉ trong 15 phút. Hiệu năng vượt trội và giao diện mượt mà.

Xiaomi 14 Pro
Xiaomi 14 Pro không chỉ có giá cả phải chăng mà còn được trang bị camera 108MP, màn hình OLED siêu sáng, và chip Snapdragon 8 Gen 3 mang lại trải nghiệm tuyệt vời.',90,'Hided',0,6),
('https://sheknowsseo.co/wp-content/uploads/2022/12/laptop-digital-nomad-table.jpg',N'Hình ảnh về laptop', N'Laptop', N'Cách Chọn Laptop Phù Hợp Cho Học Tập Và Làm Việc', 
N'Việc chọn laptop phù hợp cho học tập và làm việc là rất quan trọng. Bài viết này sẽ giúp bạn chọn chiếc laptop lý tưởng.', 
'2024-09-28', N'Khi chọn laptop, bạn cần cân nhắc nhiều yếu tố như hiệu năng, pin, trọng lượng và màn hình. Hãy chọn laptop có RAM tối thiểu 8GB, ổ cứng SSD, và CPU từ i5 trở lên để đảm bảo hiệu suất mượt mà cho các tác vụ văn phòng và học tập.', 
120, 'Published',0, 6),

-- Blog về PC
('https://media.kingston.com/kingston/hero/ktc-hero-blog-gaming-set-up-after-pc-build-lg.jpg',N'hình ảnh về PC gem minh', N'PC', N'Tư Vấn Mua PC Cho Game Thủ Năm 2024', 
N'Game thủ luôn cần một PC với cấu hình mạnh mẽ. Bài viết này sẽ cung cấp những lời khuyên để bạn chọn được chiếc PC tốt nhất.', 
'2024-09-28', N'Khi chọn PC chơi game, hiệu năng của CPU và GPU là quan trọng nhất. Bạn nên chọn các dòng CPU như Intel i7 hoặc AMD Ryzen 7 cùng với card đồ họa RTX 3070 trở lên để đảm bảo chơi mượt các tựa game hiện nay. Ngoài ra, nên đầu tư vào hệ thống tản nhiệt tốt để giữ nhiệt độ máy ổn định.', 
80, 'Published',0, 7),

-- Blog về Monitor
('https://pcmonitors.org/wp-content/uploads/2020/07/header-1.png',N'Đây là ảnh', N'Monitor', N'Top Màn Hình Máy Tính Đáng Mua Nhất Năm 2024', 
N'Màn hình máy tính là phần không thể thiếu trong trải nghiệm làm việc và giải trí. Cùng điểm qua những mẫu màn hình đáng mua nhất năm nay.', 
'2024-09-28', N'Nếu bạn làm công việc thiết kế đồ họa, màn hình có độ phân giải cao và khả năng hiển thị màu sắc chuẩn xác là điều cần thiết. Hãy chọn màn hình có tấm nền IPS, tần số quét cao như 144Hz, và độ phân giải từ 2K trở lên để có trải nghiệm tốt nhất.', 
75, 'Hided',0, 2),

-- Blog về Headphone
('https://soundpeatsvietnam.com/wp-content/uploads/2021/12/top5tainghe.jpg',N'Hình ảnh về hét phôn', N'Headphone', N'Top 5 Tai Nghe Không Dây Chất Lượng Cao Năm 2024', 
N'Các tai nghe không dây ngày càng được ưa chuộng vì tính tiện lợi. Cùng xem qua những mẫu tai nghe không dây tốt nhất hiện nay.', 
'2024-09-28', N'Tai nghe không dây đang trở thành xu hướng phổ biến với những cải tiến vượt bậc về âm thanh và kết nối. Các mẫu như Sony WH-1000XM5, Apple AirPods Pro 2, và Bose QuietComfort Earbuds II đều có khả năng chống ồn chủ động, âm thanh sống động và thời lượng pin dài.', 
60, 'Hided',0, 7),
-- Smart Phone blogs
('https://www.perfecto.io/sites/default/files/image/2020-01/social-blog-evolution-of-smartphones.png',N'Hình ảnh về điện thoại thông minh', N'Smart Phone', N'Các Mẫu Điện Thoại 5G Nổi Bật Năm 2024', N'Bài viết này giới thiệu những mẫu điện thoại 5G đáng chú ý nhất trong năm 2024.', '2024-09-29', N'Các mẫu điện thoại này không chỉ mạnh về cấu hình mà còn hỗ trợ công nghệ 5G tiên tiến.', 200, 'Published',0, 2),
('https://img.freepik.com/premium-photo/food-content-creator-blogger-camera-phone-blog-social-media-producing-sharing-content-related-food-channels-online-outlets-vlogging-culinary-meal-cooking_887181-16109.jpg',N'ảnh về sờ mát phôn', N'Smart Phone', N'Điện Thoại Pin Trâu Cho Người Bận Rộn', N'Bài viết cung cấp danh sách những điện thoại có pin dung lượng lớn, phù hợp cho người bận rộn.', '2024-09-30', N'Những chiếc điện thoại này có thời lượng pin sử dụng dài, đảm bảo bạn không lo bị gián đoạn khi làm việc cả ngày.', 180, 'Published',0, 7),

-- Laptop blogs
('https://blog.maytinhviet.vn/wp-content/uploads/2023/09/laptop_giaitri.jpg',N'Hình ảnh về laptop', N'Laptop', N'Laptop Mỏng Nhẹ Phù Hợp Cho Sinh Viên', N'Các mẫu laptop mỏng nhẹ, dễ di chuyển, phù hợp cho sinh viên học tập và làm việc.', '2024-09-29', N'Bài viết liệt kê những mẫu laptop có thiết kế nhỏ gọn nhưng vẫn đảm bảo hiệu năng tốt cho việc học tập.', 220, 'Published',0, 6),
('https://www.uplevo.com/blog/wp-content/uploads/2019/05/laptop-cho-dan-do-hoa.jpg',N'ảnh về máy tính xách tay', N'Laptop', N'Top Laptop Đáng Mua Dưới 15 Triệu', N'Dưới 15 triệu đồng, bạn có thể chọn những mẫu laptop tốt nào? Bài viết này sẽ giúp bạn.', '2024-09-29', N'Với ngân sách vừa phải, bạn vẫn có thể mua được những laptop có hiệu năng ổn định, phù hợp cho nhu cầu học tập và văn phòng.', 160, 'Published',0, 6),

-- PC blogs
('https://thanhcongcomputer.vn/wp-content/uploads/2022/12/bo-tui-nhung-cau-hinh-pc-do-hoa-chuyen-nghiep-cho-dan-thiet-ke-1.png',N'Hình ảnh pi ci', N'PC', N'PC Tối Ưu Cho Dựng Phim Và Thiết Kế Đồ Họa', N'Những PC có cấu hình mạnh mẽ để phục vụ nhu cầu dựng phim và thiết kế đồ họa.', '2024-09-29', N'Bài viết giới thiệu các bộ PC tối ưu cho công việc đòi hỏi xử lý hình ảnh và video nặng.', 170, 'Published', 0,7),
('https://www.tncstore.vn/media/news/2102.jpg',N'ảnh về máy tính', N'PC', N'Những Lưu Ý Khi Xây Dựng PC Chơi Game', N'Những điều cần chú ý khi tự xây dựng một bộ PC để chơi game.', '2024-09-30', N'Việc lựa chọn linh kiện PC chơi game cần kỹ lưỡng về CPU, GPU và tản nhiệt.', 190, 'Published',0, 2),

-- Monitor blogs
('https://www.conceptd.com.vn/wp-content/uploads/2021/02/Nhu%CC%9B%CC%83ng-lu%CC%9Bu-y%CC%81-khi-cho%CC%A3n-mua-ma%CC%80n-hi%CC%80nh-do%CC%82%CC%80-ho%CC%A3a-chuye%CC%82n-nghie%CC%A3%CC%82p-kho%CC%82ng-pha%CC%89i-ai-cu%CC%83ng-bie%CC%82%CC%81t-2-e1613975762929.jpg',N'ảnh về màn hình', N'Monitor', N'Màn Hình Chuyên Dụng Cho Thiết Kế Đồ Họa', N'Các mẫu màn hình chuyên dụng cho người làm công việc thiết kế đồ họa.', '2024-09-29', N'Những màn hình này có độ phân giải cao, khả năng hiển thị màu sắc chuẩn xác và tần số quét cao.', 130, 'Published',0, 7),
('https://tiki.vn/blog/wp-content/uploads/2023/03/man-hinh-cong.jpg', N'ảnh về màn hình',N'Monitor', N'Màn Hình Gaming 144Hz Tốt Nhất', N'Bài viết giới thiệu những màn hình 144Hz phù hợp cho game thủ.', '2024-09-29', N'Những màn hình có tần số quét cao giúp bạn chơi game mượt mà và hạn chế hiện tượng xé hình.', 140, 'Published',0, 6),

-- Headphone blogs
('https://teky.edu.vn/blog/wp-content/uploads/2022/11/ee8ad32fe40a2d6e226f454f0c0884c2c34a3c02.jpg',N'ảnh về tai nghe', N'Headphone', N'Tai Nghe Bluetooth Chống Ồn Tốt Nhất', N'Bài viết đề cập đến những mẫu tai nghe Bluetooth có khả năng chống ồn hiệu quả.', '2024-09-30', N'Tai nghe chống ồn đang trở thành lựa chọn phổ biến cho dân văn phòng và người thường xuyên di chuyển.', 120, 'Published',0, 2),
('https://cdn.nguyenkimmall.com/images/companies/_1/Content/tin-tuc/phu-kien/chon-tai-nghe-deo-thoai-mai-01.jpg',N'ảnh về tai nghe', N'Headphone', N'Tai Nghe Phù Hợp Cho Học Tập Và Làm Việc', N'Bài viết giới thiệu các mẫu tai nghe phù hợp cho học tập và làm việc tại nhà.', '2024-09-30', N'Những tai nghe này có chất lượng âm thanh tốt và giá cả phải chăng, phù hợp với học sinh và sinh viên.', 100, 'Published',0, 7),
('https://edumedia.dalat.vn//Images/LDG/liemtt/083/anh1_638117372927141698.jpg',N'ảnh về tai nghe', N'Smart Phone', N'Chào Mừng Ngày Quốc Tế Phụ Nữ', 
N'Ngày 8/3 là dịp để tôn vinh những đóng góp của phụ nữ trong xã hội. Bài viết này đề cập đến các hoạt động và sự kiện diễn ra trong ngày Quốc tế Phụ nữ.', 
'2024-03-08', 
N'Ngày Quốc tế Phụ nữ là dịp đặc biệt để ghi nhận những đóng góp của phụ nữ trong mọi lĩnh vực. Các hoạt động thường bao gồm tặng hoa, tổ chức các buổi lễ tôn vinh và các chiến dịch truyền thông về quyền bình đẳng giới.', 
250, 'Published',0, 2),
('https://static.vinwonders.com/production/y-nghia-ngay-quoc-khanh-2-9-banner.jpg',N'ảnh 2-9', N'Laptop', N'Kỷ Niệm Ngày Quốc Khánh', 
N'Ngày Quốc Khánh là dịp để người dân thể hiện lòng yêu nước, với các sự kiện lớn diễn ra khắp cả nước.', 
'2024-09-02', 
N'Ngày Quốc Khánh 2/9 là ngày lễ lớn của dân tộc. Hàng năm, lễ diễu hành và các sự kiện văn hóa thường được tổ chức để kỷ niệm ngày độc lập.', 
300, 'Published', 0,6),
('https://interactive.tinnhanhchungkhoan.vn/2016/magazine/12/nguon-goc-va-y-nghia-ngay-giang-sinh/img/1.jpg',N'ảnh 25-12', N'PC', N'Lễ Giáng Sinh Ấm Áp 2024', 
N'Lễ Giáng Sinh là một trong những ngày lễ lớn nhất trên thế giới. Bài viết này nói về các truyền thống và hoạt động trong ngày lễ Giáng Sinh.', 
'2024-12-25', 
N'Lễ Giáng Sinh diễn ra vào ngày 25/12 hàng năm, là dịp để gia đình quây quần bên nhau, trao quà và chia sẻ niềm vui. Các hoạt động đặc trưng bao gồm trang trí cây thông Noel, đi nhà thờ và tổ chức các buổi tiệc.', 
400, 'Published', 0,6),
('https://cdn.nguyenkimmall.com/images/detailed/897/ngay-quoc-te-dan-ong-0.jpeg', N'ảnh quốc tế đàn ông',N'Monitor', N'Chào Mừng Ngày Quốc Tế Nam Giới', 
N'Ngày Quốc tế Nam Giới là dịp để ghi nhận vai trò và đóng góp của nam giới trong xã hội.', 
'2024-11-19', 
N'Ngày Quốc tế Nam Giới là cơ hội để nhấn mạnh tầm quan trọng của sức khỏe và quyền lợi của nam giới, đồng thời khuyến khích những đóng góp tích cực của nam giới trong gia đình và xã hội.', 
200, 'Published', 0,7),
('https://vnn-imgs-f.vgcloud.vn/2018/05/30/06/nguon-goc-va-y-nghia-ngay-quoc-te-thieu-nhi-1-6-1.jpg',N'ảnh cho các cháu', N'Headphone', N'Chúc Mừng Ngày Quốc Tế Thiếu Nhi', 
N'Ngày Quốc tế Thiếu Nhi là dịp đặc biệt dành cho trẻ em, với các hoạt động vui chơi và quà tặng.', 
'2024-06-01', 
N'Ngày Quốc tế Thiếu Nhi 1/6 là ngày lễ dành riêng cho trẻ em. Trong ngày này, các hoạt động vui chơi, tặng quà và những buổi biểu diễn nghệ thuật thường được tổ chức để mang lại niềm vui cho các em nhỏ.', 
180, 'Published', 0,7);

--------------------------------------- Setting --------------------------------------
INSERT INTO [dbo].[Setting]
           ([Type]
           ,[Value]
           ,[Order]
           ,[Status]
           ,[Image])
     VALUES
(N'Giao diện', N'Chủ đề: Sáng', 1, 'Active', 'https://banner2.cleanpng.com/20231203/wlt/transparent-sun-icon-simple-orange-sun-icon-with-rays-on-black-1710986428863.webp'),
(N'Giao diện', N'Chủ đề: Bóng đêm', 2, 'Deactive', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRvd_63i9iNBJPgOLPr1OnT9x8TvZeT54_odA&s'),
(N'Thanh toán', N'Thanh toán qua MBBank', 3, 'Active', 'https://rubicmarketing.com/wp-content/uploads/2022/11/y-nghia-logo-mb-bank-2.jpg'),
(N'Thanh toán', N'Thanh toán qua VPBank', 4, 'Active', 'https://topads.vn/wp-content/uploads/2022/09/Logo-cua-VPBank.jpg'),
(N'Thanh toán', N'Thanh toán qua BIDV', 5, 'Active', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR81rQxFc90U_k4kJBSZA8KDPia8CMNXCMt0Q&s'),
(N'Thanh toán', N'Thanh toán qua VietcomBank', 6, 'Active', 'https://cdn.tuoitre.vn/thumb_w/1200/471584752817336320/2023/2/23/logo-vietcombank-inkythuatso-10-10-41-18-16771235759271889182462.jpg'),
(N'Thanh toán', N'Thanh toán qua VietinBank', 7, 'Deactive', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQBUlIVX-o9DEN6spNeph3SJ0giiQap9v6IUQ&s'),
(N'Thanh toán', N'Thanh toán qua ACB', 8, 'Active', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJp5tOF1bgyprmjY_u5-RsgYIJPyE31L665g&s'),
(N'Khuyến mãi', N'Happy Halloween', 9, 'Deactive', 'https://t4.ftcdn.net/jpg/02/26/42/03/360_F_226420352_RVF4lqUk732H9uAnQxnr0Prqd3RfYOLp.jpg'),
(N'Thanh toán', N'Thanh toán qua Techcombank', 10, 'Deactive', 'https://upload.wikimedia.org/wikipedia/commons/7/7c/Techcombank_logo.png'),
(N'Thanh toán', N'Thanh toán qua Agribank', 11, 'Active', 'https://fdesign.vn/wp-content/uploads/2022/07/logo-ngan-hang-agribank-1.jpg'),
(N'Thanh toán', N'Thanh toán qua TPBank', 12, 'Active', 'https://cdn.tuoitre.vn/thumb_w/1200/471584752817336320/2023/2/23/9d8ed59b46446656b14efc88b058399cd81d9amv2-1677151417649694732849.png'),
(N'Khuyến mãi', N'Giảm 20% cho sinh viên', 13, 'Deactive', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSymffE5HmLcEo7rB97Awq0txJTE8-uVKOBEw&s'),
(N'Khuyến mãi', N'Tặng quà cho đơn hàng > 20 triệu', 14, 'Active', 'https://caesargroup.vn/uploads/tin-tuc/2020_10/qua-tang-don-hang-200-trieu.jpg'),
(N'Khuyến mãi', N'Black Friday (23/11-29/11)', 15, 'Active', 'https://image3.luatvietnam.vn/uploaded/images/original/2024/07/11/black-friday-la-ngay-nao_1107132225.jpg');
 ------------------------------------- PersonAddress ---------------------------------------
INSERT INTO PersonAddress (PersonID, Address, IsPrimary)
VALUES
    (1, N'123 Ðuờng A, Hà Nội', 1), -- Nguyên Van Nam
    (2, N'456 Ðuờng B, Hồ Chí Minh', 1), -- Nguyên Thị Bích
    (3, N'789 Ðuờng C, Ðà Nẵng', 1), -- Trần Van Luơng
    (4, N'321 Ðuờng D, Hà Nội', 1), -- Phạm Quang Vu
    (5, N'654 Ðuờng E, Hồ Chí Minh', 1), -- Lê Thanh Thúy
    (6, N'456 Ðuờng F, Hồ Chí Minh', 1), -- Đằng Nhật Nam
    (7, N'123 Ðuờng M, Hồ Chí Minh', 1),
	(8, N'123 Ðuờng M, Hồ Chí Minh', 1),
	(9, N'123 Ðuờng M, Hồ Chí Minh', 1),
	(10, N'123 Ðuờng M, Hồ Chí Minh', 1),
	(11, N'123 Ðuờng M, Hồ Chí Minh', 1),
	(12, N'123 Ðuờng M, Hồ Chí Minh', 1);-- Phan Đăng Lưu
	
--------- Thêm số điện thoại cho các người dùng--------------------
INSERT INTO PersonPhone (PersonID, Phone, IsPrimary)
VALUES
    (1, '0901000001', 1), -- Nguyên Van Nam
    (2, '0902000002', 1), -- Nguyên Thị Bích
    (3, '0903000003', 1), -- Trần Van Luơng
    (4, '0904000004', 1), -- Phạm Quang Vu
    (5, '0905000005', 1), -- Lê Thanh Thúy
    (6, '0298376122', 1), -- Đằng Nhật Nam
    (7, '0987132823', 1),
	(8, '0876142872', 1),-- Phan Đăng Lưu
	(9, '0781293622', 1),
	(10,'0978163221', 1),
	(11,'0978132223', 1),
	(12,'0128738218', 1);


		  
--------------------------------- Cart -----------------------------------
INSERT INTO Cart (PersonID, TotalPrice)
VALUES (1, 0);

INSERT INTO CartItem (CartID, ProductID, Quantity, Price)
VALUES 
(1, 4, 2, 100.00), 
(1, 5, 1, 150.00), 
(1, 6, 3, 200.00); 
-------------------------------- Comment Blog ---------------------------------------

CREATE TABLE CommentBlog (
    CommentID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    CommentText NVARCHAR(1000) NOT NULL,
    CommentDate DATE NOT NULL,
    PersonID INT NOT NULL,
    BlogID INT NOT NULL,
    FOREIGN KEY (PersonID) REFERENCES Person(PersonID),
    FOREIGN KEY (BlogID) REFERENCES Blog(BlogID)
);

INSERT INTO CommentBlog(CommentText, CommentDate, PersonID, BlogID)
VALUES 
(N'Tôi rất thích bài viết này, nó cung cấp nhiều thông tin hữu ích về các mẫu điện thoại mới.', '2024-10-01', 1, 1),
(N'Thông tin trong bài viết rất chính xác, đặc biệt là phần về camera. Rất hữu ích!', '2024-10-02', 3, 1),
(N'Cảm ơn tác giả! Bài viết giúp tôi chọn được chiếc laptop ưng ý.', '2024-10-03', 5, 3),
(N'Rất bổ ích cho những ai đang tìm kiếm một PC chơi game tốt. Xin cảm ơn.', '2024-10-05', 4, 4),
(N'Bài viết này đã giúp tôi hiểu thêm về các mẫu tai nghe Bluetooth hiện đại.', '2024-10-07', 1, 6);

------------------------------------------------------------------------Sider-------------------------------
CREATE TABLE Slider (
    SliderID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    SliderTittle NVARCHAR(500) NOT NULL,
    SliderImage TEXT,
	SliderVideo TEXT,
    SliderBacklink TEXT NOT NULL,
    SliderDate DATE NOT NULL,
    SliderStatus VARCHAR(50) NOT NULL,
	SliderNote NTEXT,
    PersonID INT NOT NULL,
    FOREIGN KEY (PersonID) REFERENCES Person(PersonID)
);
INSERT INTO Feedback (CustomerID, ProductID, RatedStar, FeedbackContent, FeedbackReply, ProcessedBy, Status, CreatedDate, ProcessedDate)
VALUES
(1, 1, 5, N'Sản phẩm chất lượng tốt, tôi rất hài lòng!', NULL, NULL, N'New', GETDATE(), NULL),
(2, 1, 4, N'Sản phẩm khá ổn nhưng giao hàng hơi chậm.', N'Chúng tôi xin lỗi về sự chậm trễ và sẽ cải thiện dịch vụ giao hàng.', 6, N'Resolved', GETDATE(), DATEADD(day, 2, GETDATE())),
(3, 3, 3, N'Sản phẩm dùng tạm được, giá hơi cao so với chất lượng.', N'Cảm ơn phản hồi của bạn. Chúng tôi sẽ xem xét lại giá sản phẩm.', 7, N'Resolved', GETDATE(), DATEADD(day, 3, GETDATE())),
(4, 3, 5, N'Tôi đã mua sản phẩm này nhiều lần, rất tin tưởng.', NULL, NULL, N'New', GETDATE(), NULL),
(5, 15, 2, N'Không hài lòng với sản phẩm, giao hàng bị trầy xước.', NULL, NULL, N'New', GETDATE(), NULL),
(1, 2, 1, N'Sản phẩm kém chất lượng, tôi muốn hoàn trả.', N'Chúng tôi rất tiếc về trải nghiệm của bạn. Vui lòng liên hệ bộ phận CSKH để được hỗ trợ hoàn trả.', 6, N'Resolved', GETDATE(), DATEADD(day, 1, GETDATE())),
(2, 2, 4, N'Dịch vụ chăm sóc khách hàng rất tốt, sản phẩm ổn.', N'Cảm ơn bạn đã đánh giá cao dịch vụ của chúng tôi!', 7, N'Resolved', GETDATE(), DATEADD(day, 2, GETDATE())),
(3, 30, 5, N'Tôi sẽ giới thiệu sản phẩm này cho bạn bè.', NULL, NULL, N'New', GETDATE(), NULL),
(4, 79, 4, N'Sản phẩm tốt nhưng vẫn cần cải tiến.', N'Cảm ơn góp ý của bạn. Chúng tôi sẽ tiếp tục cải tiến sản phẩm.', 6, N'Resolved', GETDATE(), DATEADD(day, 4, GETDATE())),
(5, 40, 3, N'Khá hài lòng, tuy nhiên thời gian giao hàng hơi lâu.', N'Chúng tôi đang nỗ lực cải thiện thời gian giao hàng. Cảm ơn phản hồi của bạn!', 7, N'Resolved', GETDATE(), DATEADD(day, 3, GETDATE()));



INSERT INTO Slider (SliderTittle, SliderImage,SliderVideo, SliderBacklink,SliderDate,SliderStatus,SliderNote,PersonID)
VALUES 
(N'Ưu đãi tháng Oppo','https://cdn2.cellphones.com.vn/insecure/rs:fill:690:300/q:90/plain/https://dashboard.cellphones.com.vn/storage/thang-oppo-muon-van-uu-dai-home.jpg',
NULL,'https://www.example.com','2024-08-16','Published',N'Hình ảng mang tính chất minh họa',6),
(N'Ưu đãi tháng Iphone 16','https://cdn2.cellphones.com.vn/insecure/rs:fill:690:300/q:90/plain/https://dashboard.cellphones.com.vn/storage/sliding-home-iphone-16-pro-km-moi.jpg',
NULL,'https://www.facebook.com','2024-10-18','Published',N'Slider viết cho iphon16 mới ra mắt dành cho tháng ưu đãi',6),
(N'Ưu đãi tháng Laptop','https://cdn2.cellphones.com.vn/insecure/rs:fill:690:300/q:90/plain/https://dashboard.cellphones.com.vn/storage/laptop-ai-banner-chung-slide.png',
NULL,'https://www.youtube.com','2024-06-20','Published',Null,6),
(N'Ưu đãi tháng HeadPhone','https://i.ytimg.com/vi/fQbHCL5iWrA/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLDeTw7M14kA9J5KsIb68xc89B2LUA',
NULL,'https://cellphones.com.vn/','2023-12-12','Hided',Null,6),
(N'Ưu đãi tháng màn hình','https://i.ytimg.com/vi/FVW2kweqZAc/hqdefault.jpg',
NULL,'https://onlyfans.com/','2013-05-03','Hided',Null,7);


INSERT INTO PersonImages
Values
(1,'img/person1.png','Person Image',1),
(1,'img/person2.png','Person Image',1)

--------------------------------Trigger để updateOrderTotal--------------------------------------
CREATE OR ALTER TRIGGER UpdateOrderTotal
ON OrderDetails
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    UPDATE O
    SET TotalMoney = (SELECT COALESCE(SUM(Quantity * UnitPrice), 0) 
                      FROM OrderDetails 
                      WHERE OrderID = O.OrderID)
    FROM Orders O
    WHERE O.OrderID IN (SELECT DISTINCT OrderID FROM inserted)
       OR O.OrderID IN (SELECT DISTINCT OrderID FROM deleted)
END;


CREATE UNIQUE INDEX UQ_PersonPhone
ON PersonPhone (PersonID)
WHERE IsPrimary = 1;

CREATE UNIQUE INDEX UQ_PersonAddress
ON PersonAddress (PersonID)
WHERE IsPrimary = 1;

CREATE UNIQUE INDEX UQ_PersonImages
ON PersonImages (PersonID)
WHERE IsPrimary = 1


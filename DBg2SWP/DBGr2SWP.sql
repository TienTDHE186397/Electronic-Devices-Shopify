--CREATE DATABASE DBGr2SWP5
--USE  DBGr2SWP5

--drop table Person
CREATE TABLE Person(
    PersonID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    Name NVARCHAR(50),
    Gender NVARCHAR(6),
    DateOfBirth DATE,
    Email VARCHAR(100),
    Phone VARCHAR(15)
);

--drop table Roles
CREATE TABLE Roles (
    RoleID INT IDENTITY(1,1) NOT NULL PRIMARY KEY,-- Mã định danh duy nhất cho mỗi vai trò.
    RoleName NVARCHAR(50) NOT NULL--Tên của vai trò (ví dụ: quản trị viên, người bán, khách hàng).
);

--drop table Account
CREATE TABLE Users(
    Username VARCHAR(50) NOT NULL PRIMARY KEY,
    Password VARCHAR(50) NOT NULL,
    PersonID INT NOT NULL,
    RoleID INT NOT NULL,
    FOREIGN KEY (PersonID) REFERENCES Person(PersonID),
    FOREIGN KEY (RoleID) REFERENCES Roles(RoleID)
);

--drop table Wallets
CREATE TABLE Wallets (
    WalletID INT IDENTITY(1,1) not null  PRIMARY KEY ,--Mã định danh duy nhất cho mỗi ví điện tử.
    Balance DECIMAL(10, 2),--Số dư trong ví điện tử
	PersonID int not null,
    FOREIGN KEY (PersonID) REFERENCES Person(PersonID)
 );

--drop table Categories
CREATE TABLE Categories (
    CategoryID INT IDENTITY(1,1) NOT NULL ,--: Mã định danh duy nhất cho mỗi thể loại.
    CategoryName [nvarchar](50) COLLATE Vietnamese_CI_AS NOT NULL,--Tên của thể loại phim.
    [Description] [nvarchar](MAX) COLLATE Vietnamese_CI_AS NULL--Mô tả về thể loại (có thể để trống).
	CONSTRAINT [PK_Categories] PRIMARY KEY([CategoryID])
);

CREATE TABLE ShowRoom (
    [ShowRoomID] INT IDENTITY(1,1) NOT NULL PRIMARY KEY,-- Mã định danh duy nhất cho mỗi rạp chiếu phim.
    [ShowRoomName] NVARCHAR(100) NOT NULL,--Tên của rạp chiếu phim.
    [Address] NVARCHAR(500) NOT NULL--Địa chỉ của rạp chiếu phim.
);

--drop table Products
CREATE TABLE Products (
    [ProductID] int IDENTITY(1,1) NOT NULL PRIMARY KEY,--Mã định danh duy nhất cho mỗi sản phẩm (phim).
    [Views] NVARCHAR(MAX) NULL,--Số lượt xem san pham 
    [releaseDate] DATE NULL,--Ngày phát hành của san pham.
    [QuantitySold] INT NULL,--Số lượng san pham da ban
	[favourite] int null,-- So thich 
    [CategoryID] INT NULL,--Khóa ngoại liên kết với bảng Categories, xác định thể loại của phim.
     Quantity int not null,
	[ShowRoomID] INT NULL,--Khóa ngoại liên kết với bảng Cinema, xác định rạp chiếu phim của sản phẩm.
    CONSTRAINT [FK_Products_Category] FOREIGN KEY ([CategoryID]) REFERENCES [dbo].[Categories] ([CategoryID]),
    CONSTRAINT [FK_Products_ShowRoom] FOREIGN KEY ([ShowRoomID]) REFERENCES [dbo].[ShowRoom] ([ShowRoomID])
);

--drop table Phone
Create table Phone(
PhoneID nvarchar(10) primary key not null,--Mã định danh duy nhất cho mỗi điện thoại
ProductID nvarchar(10), --mã định danh cho sản phẩm 
PhoneName nvarchar(255) not null,--Tên sản phẩm
Price int not null,--Giá của sản phẩm
ScreenSize decimal(10,2) not null,--Kích thước màn hình của sản phẩm
DisplayTech nvarchar(255) not null,--Công nghệ màn hình của sản phẩm
RearCamera nvarchar(255) not null,--Camera sau của sản phẩm
FrontCamera nvarchar(255) not  null,--Camera trước của sản phẩm
Chipset nvarchar(255) not null,--Chip của mỗi sản phẩm
RAMCapicity int not null,--Dung lượng RAM của sản phẩm
InternalMemory int not null,--Bộ nhớ trong của sản phẩm
Battery nvarchar(255) not null,--Pin của sản phẩm
OperatingSystem nvarchar(255) not null,--Hệ điều hành của sản phẩm
ScreenResolution nvarchar(255) not null,--Độ phân giải màn hình của sản phẩm
img NVARCHAR(MAX) NULL,
)
--drop table Laptop
create table Laptop(
   LaptopID nvarchar(50) not null primary key,
   ProductID int not null,
   price int not null,
   LapName nvarchar(150) not null,
   genre nvarchar(150) not null,
   CPU nvarchar(150) not null,
   Ram nvarchar(150) not null,
   Graphic_Card nvarchar(150) not null,
   Hard_Drive nvarchar(150) not null,
   Monitor nvarchar(300) not null,
   LAN nvarchar(50) not null,
   WIFI nvarchar(50) not null,
   Bluetooth nvarchar(30) not null,
   Webcam nvarchar(100) not null,
   Operating_System nvarchar(100) not null,
   Pin nvarchar(50) not null,
   Lap_Weight nvarchar(50) not null,
   Lap_colour nvarchar(50) not null,
   Size nvarchar(100) not null,
   img NVARCHAR(MAX) NULL,
   description nvarchar(MAX) null,
   FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE Headphones (
    Headphoneid nvarchar(200) PRIMARY KEY not null,
	HeadphoneName nvarchar(200) not null,
    brand nvarchar(200) NOT NULL,
    model nvarchar(200) NOT NULL,
    Features nvarchar(200) NOT NULL, -- Tính nữa
    connection nvarchar(200) NOT NULL,--kieu ket noi co day hay ko day
    battery_life INTEGER,
    noise_cancel nvarchar(200),
    price int not null,
	img nvarchar(MAX),
    description nvarchar(MAX),
	ProductID int not null,
	FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE PC(
	pcId NVARCHAR(10) PRIMARY KEY NOT NULL, -- Mã định danh cho mỗi loại máy tính
	ProductID int not null,
	pcImage NVARCHAR(255) NOT NULL, -- Ảnh sản phẩm
	pcName NVARCHAR(255) NOT NULL, -- Tên sản phẩm máy tính
	pcBranch NVARCHAR(50) NOT NULL, -- Tên thương hiệu máy tính
	pcPrice INT, --Giá của sản phẩm
	pcCPU NVARCHAR(255) NOT NULL, -- Thông tin về vi xử lý
	pcMemory NVARCHAR(255) NOT NULL, --Thông tin về bộ nhớ ram(GB)
	pcDiskMemory NVARCHAR(255) NOT NULL, -- Thông tin về ổ cứng(GB)
	pcVga NVARCHAR(255) NOT NULL, -- Thông tin về vi xử lý đồ hoạ
	pcNetworkLan NVARCHAR(255) NOT NULL, -- Thông tin về card mạng 
	pcPower INT, -- Thông tin về công suất điện (W)
	pcSize NVARCHAR(255) NOT NULL, -- Thông tin về kích cỡ(L x W x H) mm hoặc cm
	pcWeight DECIMAL(4,2), -- Thông tin về khối lượng(kg)
	pcFrontPort NVARCHAR(255) NOT NULL, -- Thông tin về cổng trước
	pcBackPort NVARCHAR(255) NOT NULL, --Thông tin về cổng sau 
	pcGuarantee INT NOT NULL, -- Thông tin bảo hành(Tháng,month)
)

--drop table ShowRoomDetail
Create table ShowRoomDetail(
   ShowRoomID int not null,
   ProductID int not null,
   CONSTRAINT [FK_ShowRoomDetail_Product] FOREIGN KEY (ProductID) REFERENCES [dbo].[Products] (ProductID),
   CONSTRAINT [FK_ShowRoomDetail_ShowRoom] FOREIGN KEY ([ShowRoomID]) REFERENCES [dbo].[ShowRoom] ([ShowRoomID])
);

--drop table Comment
Create table Comment(
CommentID INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
ProductID int not null,
PersonID  int not null,
CommentDetail nvarchar(255) not null,
FOREIGN KEY (ProductID) REFERENCES Products(ProductID),
FOREIGN KEY (PersonID) REFERENCES Person(PersonID)

);
CREATE TABLE Orders (
    OrderID INT IDENTITY(1,1) NOT NULL PRIMARY KEY,--Mã định danh duy nhất cho mỗi đơn đặt hàng.
    [OrderDate] DATETIME NOT NULL,  --Ngày và giờ đặt hàng.
    PersonID int NOT NULL,--Khóa ngoại liên kết với bảng Account, xác định người dùng đã đặt hàng.
    ShowRoomID INT NOT NULL,--Khóa ngoại liên kết với bảng Rooms, xác định phòng chiếu được đặt.
    TotalMoney DECIMAL(10, 2) NULL,--Tổng số tiền của đơn hàng.
    Method NVARCHAR(MAX) NOT NULL,-- Phương thức thanh toán.
	Status nvarchar(255) not null,--trang thai don hang
	FOREIGN KEY (ShowRoomID) REFERENCES  ShowRoom(ShowRoomID),
    FOREIGN KEY (PersonID) REFERENCES Person(PersonID)
);

--drop table Gift
CREATE TABLE Gift (
    GiftID INT IDENTITY(1,1) NOT NULL PRIMARY KEY,--Mã định danh duy nhất cho mỗi món ăn hoặc thức uống.  
    GiftName NVARCHAR(50) NOT NULL,--Tên của món ăn hoặc thức uống.
    Quantity int not null,
	[image] VARCHAR(255),
);
--drop table OrderDetails

CREATE TABLE OrderDetails (
    OrderDetailID INT IDENTITY(1,1) NOT NULL PRIMARY KEY,--Mã định danh duy nhất cho mỗi mục chi tiết đơn hàng.
    OrderID INT NOT NULL,--Khóa ngoại liên kết với bảng Orders, xác định đơn hàng chứa mục này.
    ProductID INT NULL,--Khóa ngoại liên kết với bảng Products, xác định sản phẩm (phim) trong đơn hàng.
    GiftID INT NULL, -- Khóa ngoại liên kết với bảng FoodandDrink, xác định món ăn hoặc thức uống trong đơn hàng.
    Quantity INT NOT NULL,--Số lượng của mục này trong đơn hàng.
    CONSTRAINT FK_OrderDetails_Orders FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    CONSTRAINT FK_OrderDetails_Products FOREIGN KEY (ProductID) REFERENCES Products(ProductID),
    CONSTRAINT FK_OrderDetails_FoodAndDrink FOREIGN KEY (GiftID) REFERENCES Gift(GiftID)
);

CREATE TABLE Deposit (
    DeId INT IDENTITY(1,1) NOT NULL PRIMARY KEY,--Mã định danh duy nhất cho mỗi lần nạp tiền.  	
    UserName NVARCHAR(50) NOT NULL,--Khóa ngoại liên kết với bảng Account, xác định người dùng đã nạp tiền.
    [Money] INT NOT NULL,--Số tiền đã nạp.
	[Status] INT NOT NULL--Trạng thái của lần nạp tiền (ví dụ: thành công, đang chờ xử lý).
);


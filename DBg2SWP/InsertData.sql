USE  DBGr2SWP4

INSERT INTO Person (Name, Gender, DateOfBirth, StartDate, Address, Email, Phone) 
VALUES 
(N'Nguyễn Văn Nam', N'Nam', '1980-01-01', NULL, N'123 Đường A, Hà Nội', 'vana@gmail.com', '0901000001'),
(N'Nguyễn Thị Bích', N'Nữ', '1990-02-02', NULL, N'456 Đường B, Hồ Chí Minh', 'thib@gmail.com', '0902000002'),
( N'Trần Văn Lượng', N'Nam', '1985-03-03', NULL, N'789 Đường C, Đà Nẵng', 'vanc@gmail.com', '0903000003'),
( N'Phạm Quang Vũ', N'Nam', '1975-04-04', '2010-01-01', N'321 Đường D, Hà Nội', 'vand@gmail.com', '0904000004'),
( N'Lê Thị Thúy', N'Nữ', '1988-05-05', '2012-02-02', N'654 Đường E, Hồ Chí Minh', 'thie@gmail.com', '0905000005'),
(N'Phạm Văn Tiến', N'Nam', '1992-06-06', '2015-03-03', N'987 Đường F, Đà Nẵng', 'vanf@gmail.com', '0906000006'),
(N'Phạm Đức Long', N'Nam', '2004-09-27', NULL, N'123 Đường G, Hà Nội', 'longpd@gmail.com', '0907000007'),
(N'Trần Thị Linh', N'Nữ', '1995-08-08', NULL, N'456 Đường H, Hồ Chí Minh', 'thih@gmail.com', '0908000008'),
(N'Phạm Phúc Lân', N'Nam', '1998-09-09', NULL, N'789 Đường I, Đà Nẵng', 'vani@gmail.com', '0909000009'),
(N'Lê Thị Hà', N'Nữ', '1987-10-10', NULL, N'321 Đường J, Hà Nội', 'thij@gmail.com', '0910000010');

INSERT INTO Roles(RoleName)
Values
('customer'),
('makerting'),
('sale'),
('saleManager'),
('admin');

INSERT INTO Account (UserName, [Password],[Age],RoleID) VALUES
('Admin','123',18,6),
('customer1','123',18,1),
('customer2','123',18,1),
('makerting1','123',20,2),
('makerting2','123',22,2),
('shipper1','123',23,5),
('shipper2','123',24,5),
('sale1','123',23,3),
('sale2','123',23,3),
('saleManager1','123',24,4);

Insert into Wallets(UserName,Balance) Values
('customer1',0),
('customer2',0);

Insert into Categories(CategoryName,Description) Values
('Phone-Tablet',null),
('Laptop',null),
('PC',null),
('Monitor',null),
('Earphone',null);

Insert into ShowRoom(ShowRoomName,[Address]) Values
(N'Thành phố Hà Nội ',N'Số 123 Đường 456 Quận Bắc Từ Liêm Thành Phố Hà Nội '),
(N'Thành phố Đà Nẵng',N'Số 789 Đường 101 Quận Liên Chiểu Thành Phố Đà Nẵng '),
(N'Thành phố Hồ Chí Minh',N'Số 102 Đường 1013 Quận Gò Vấp Thành Phố Hồ Chí Minh ');

Insert into [dbo].[Gift](GiftID,GiftName,Quantity,[image]) values
	(1,N'Túi đựng laptop',50,N'gitimg/git1.jpg'),
	(2,'Bình dữ nhiệt',50,N'gitimg/git2.jpg'),
	(3,'Quạt điện cơ x19',50,N'gitimg/git3.jpg'),
	(4,'Chảo chống dính',50,N'gitimg/git4.jpg'),
	(5,N'Nước lọc lavie',50,N'gitimg/git5.jpg');

INSERT INTO Laptop (LaptopID, ProductID, Genre) 
VALUES
('L01', 'PL01', 'Gaming'),
('L02', 'PL02', 'Gaming'),
('L03', 'PL03', 'Gaming'),
('L04', 'PL04', 'Gaming'),
('L05', 'PL05', 'Gaming'),
('L06', 'PL06', 'Gaming'),
('L07', 'PL07', 'Gaming'),
('L08', 'PL08', 'Gaming'),
('L09', 'PL09', 'Gaming'),
('L10', 'PL10', 'Gaming'),
('L11', 'PL11', 'Business'),
('L12', 'PL12', 'Business'),
('L13', 'PL13', 'Gaming'),
('L14', 'PL14', 'Gaming'),
('L15', 'PL15', 'Business'),
('L16', 'PL16', 'Business'),
('L17', 'PL17', 'Business'),
('L18', 'PL18', 'Business'),
('L19', 'PL19', 'Business'),
('L20', 'PL20', 'Business');

INSERT INTO LaptopDetail (LapDetailID, LaptopID, LapName, CPU, Ram, Graphic_Card, Hard_Drive, Monitor, LAN, WIFI, Bluetooth, Webcam, Operating_System, Pin, Lap_Weight, Lap_colour, Size, img) 
VALUES 
('LG01', 'L01', 'Laptop gaming Acer Predator Helios 300 PH315 55 76KG', 'Intel® Core™ i7-12700H (up to 4.7Ghz, 24MB cache)', '16GB DDR5 4800Mhz (2x8GB) (2x SO-DIMM socket, up to 32GB SDRAM)', 'NVIDIA GeForce RTX 3060 6GB GDDR6', '512GB NVMe PCIe Gen3x4 SSD ', '15.6 inch QHD (2560 x1440) IPS 165Hz, DCI-P3 100%, 5ms, 300nits, SlimBezel', 'Killer Ethernet E2600', 'Intel Wi-Fi 6E (2*2 ax)', 'v5.2', '1080p HD video at 60 fps with Temporal Noise Reduction', 'Windows® 11 Home', '4 cell, 90Whr', '2.4 kg', 'Black', '359.4 x 276.4 x 25.55 mm', 'https://product.hstatic.net/200000722513/product/76kg_1433e407838944df88bd906b57729c0a_1024x1024.png'),
('LG02', 'L02', 'Laptop gaming Lenovo LOQ 15IAX9 83GS001QVN', 'Intel® Core™ i5-12450HX, 8C (4P + 4E) / 12T, P-core up to 4.4GHz, E-core up to 3.1GHz, 12MB', '12GB (1x12GB) DDR5-4800 SO-DIMM (2x SO-DIMM socket, up to 32GB SDRAM)', 'NVIDIA® GeForce RTX™ 4050 6GB GDDR6, Boost Clock 2370MHz, TGP 105W', '512GB SSD M.2 2242 PCIe 4.0x4 NVMe', '15.6" FHD (1920x1080) IPS 300nits Anti-glare, 100% sRGB, 144Hz, G-SYNC®', 'RJ45 Ethernet port', 'Wi-Fi® 6', 'v5.2', 'FHD 1080p with E-shutter', 'Windows® 11 Home', 'Integrated 60Wh (3 Cell)', '2.38 kg', 'Luna Grey', '359.86 x 258.7 x 21.9-23.9 mm', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJixy1uhvUS4wSs7SAIaApQjxeJeQQIrvYxQ&s'),
('LG03', 'L03', 'Laptop gaming Acer Nitro V ANV15 51 57B2', 'Intel Core i5-13420H 3.3GHz up to 4.4GHz, 12MB Smart Cache, 8 Cores 12 Threads', '8GB (8x1) DDR5 5200MHz (2x SO-DIMM socket, up to 32GB SDRAM)', 'NVIDIA® GeForce RTX™ 4050 with 6 GB of dedicated GDDR6 VRAM', '512GB PCIe NVMe SED SSD', '15.6" FHD (1920 x 1080) IPS, 144Hz, 3ms, Acer ComfyView LED-backlit TFT LCD, 45% NTSC', 'Gigabit Ethernet', 'Wi-Fi® 6', 'v5.1', '720p HD audio/video recording', 'Windows® 11 Home', '4 Cell 57WHr', '2.1 kg', 'Obsidian Black', '362.3 x 239.89 x 22.9/26.9 mm', 'https://product.hstatic.net/200000837185/product/acer-gaming-nitro-v-2023-3_11c2042c95124816886f05ec5941aa38_master.jpg'),
('LG04', 'L04', 'Laptop gaming ASUS ROG Zephyrus G14 GA403UV QS170W', 'AMD Ryzen™ 9 8945HS (8 cores, 16 threads, 4.0GHz upto 5.2GHz, 16MB Cache)', '32GB (16x2) LPDDR5X 6400MHz Onboard', 'NVIDIA® GeForce RTX™ 4060 Laptop GPU', '1TB PCIe® 4.0 NVMe™ M.2 SSD', '14" 3K (2880 x 1800) 16:10, OLED, 120Hz/0.2ms, DCI-P3: 100%, Pantone Validated, Glossy display, 500nits, G-Sync / Adaptive-Sync, Dolby vision, ROG Nebula Display', NULL, 'Wi-Fi 6E(802.11ax)', 'v5.3', '1080P FHD IR Camera for Windows Hello', 'Windows® 11 Home', '4 Cell 73WHr', '1.5 kg', 'Platinum White', '31.1 x 22.0 x 1.59 ~ 1.63 (cm)', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhkn84UbPK-vIOPWIj1F5HuQur-b-WT0ZGaw&s'),  
('LG05', 'L05', 'Laptop gaming MSI Katana 15 B13VEK 252VN', 'Intel Core i7-13620H (3.6GHz~4.9GHz) 10 Cores 16 Threads', '8GB (1 x 8GB) DDR5 5200MHz (2x SO-DIMM socket, up to 64GB SDRAM)', 'NVIDIA GeForce RTX 4050 Laptop GPU 6GB GDDR6', '512GB NVMe PCIe Gen 4 SSD', '15.6" FHD (1920x1080), 144Hz, IPS-Level', 'Gigabit Ethernet', 'Wi-Fi® 6', 'v5.2', 'HD type (30fps@720p)', 'Windows® 11 Home', '3 cell, 53.5Whr', '2.25 kg', 'Black', '359 x 259 x 24.9 mm', 'https://product.hstatic.net/200000722513/product/1205vn_da651643e91047bfa9729c53f93ffc6e_large_39f1561f3448481c94add35d7fda7dc4.png' ),
('LG06', 'L06', 'Laptop gaming Gigabyte G5 KF E3VN333SH', 'Intel® Core™ i5-12500H (2.5GHz~4.5GHz), 12 Cores, 16 Threads (4P + 8E), 18 MB Intel® Smart Cache', '8GB (1x8GB) DDR4-3200Mhz (2 khe ram, nâng cấp tối đa 64GB RAM)', 'NVidia Geforce RTX 4060 8GB GDDR6 + Intel Iris Xe Graphics', '512GB SSD M.2 PCIE G4X4', '15.6 inch FHD (1920x1080), 144Hz, IPS-level, Thin Bezel, 45% NTSC', 'Gigabit Ethernet', 'Intel® Wi-Fi 6', 'v5.2', 'HD 720p', 'Windows® 11 Home', 'Lithium-Ion 54Wh', '1,9 kg', 'Black', '36.0 x 23.8 x 2.27 cm', 'https://anphat.com.vn/media/product/45085_laptop_gigabyte_g5_kf_e3vn333sh_anphatpc6.jpg'),
('LG07', 'L07', 'Laptop gaming Dell G15 5530 i9H161W11GR4060', 'Intel® Core™ i9-13900HX (36 MB cache, 24 cores, 32 threads, up to 5.40 GHz Turbo)', '16GB (2x8GB) DDR5 4800MHz (2x SO-DIMM socket, up to 32GB SDRAM)', 'NVIDIA® GeForce RTX™ 4060 8GB GDDR6', '1TB SSD M.2 PCIe NVMe', '15.6" FHD (1920x1080) 165Hz, 3ms, sRGB-100%, ComfortViewPlus, NVIDIA G-SYNC+DDS Display', 'RJ45 Ethernet port', 'Intel® Wi-Fi 6 AX201', 'v5.2', 'Integrated widescreen HD (720p)', 'Windows 11 Home + Office Home & Student', '6 Cell 86WHrs', '2.81 kg', 'Dark Shadow Grey', '357.26 x 274.52 x 26.95 mm', 'https://product.hstatic.net/200000722513/product/ava_3bcf0035952f41a2847797845ef41b81_1024x1024.png'),
('LG08', 'L08', 'Laptop gaming Dell G15 5525 R7H165W11GR3060', 'AMD Ryzen 7 6800H (8C / 16T, 3.2 / 4.7GHz, 4MB L2 / 16MB L3)', '16GB (2x8GB) DDR5 4800MHz (2x SO-DIMM socket, up to 32GB SDRAM)', 'NVIDIA® GeForce RTX™ 3060 6GB GDDR6', '512GB SSD M.2 PCIe PCIE G4X4', '15.6-inch FHD (1920 x1080) 120Hz, 250 nits, WVA, Anti-Glare, LED Backlit, Narrow Border Display', 'RJ45 Ethernet port', 'Wi-Fi 6 (802.11ax)', 'v5.2', 'HD camera (720p)', 'Windows 11 Home + Office Home & Student', '3 Cell 56WHrs', '2.72 kg', 'Dark Shadow Grey', '357.26 x 272.11 x 26.90 mm', 'https://laptopworld.vn/media/product/13236_dell_gaming_g15_5525_2.jpg'),
('LG09', 'L09', 'Laptop gaming Lenovo LOQ 15ARP9 83JC003YVN', 'AMD Ryzen™ 7 7435HS (8C / 16T, 3.1 / 4.5GHz, 4MB L2 / 16MB L3)', '24GB (2x12GB) DDR5-4800 SO-DIMM (2x SO-DIMM socket, up to 32GB SDRAM)', 'NVIDIA® GeForce RTX™ 4060 8GB GDDR6, Boost Clock 2370MHz, TGP 105W', '512GB SSD M.2 2242 PCIe® 4.0x4 NVMe®', '15.6" FHD (1920x1080) IPS 300nits Anti-glare, 100% sRGB, 144Hz, G-SYNC®', 'RJ45 Ethernet port', 'Wi-Fi® 6', 'v5.2', 'HD 720p with E-shutter', 'Windows® 11 Home', 'Integrated 60Wh (4 Cell)', '2.38 kg', 'Luna Grey', '359.86 x 258.7 x 21.9-23.9 mm', 'https://product.hstatic.net/200000722513/product/ava-trang_96d26f2b6f5443e78f5ef21b5c6a6b7e_1024x1024.png'),
('LG10', 'L10', 'Laptop gaming ASUS ROG Strix SCAR 15 G533ZW LN134W', 'Intel Core i9-12900H 3.8GHz up to 5.0GHz 24MB', '32GB (16GBx2) DDR5 4800MHz (2x SO-DIMM socket, up to 64GB SDRAM)', 'NVIDIA GeForce RTX 3070 Ti 8GB GDDR6 + MUX Switch', '1TB M.2 NVMe PCIe 4.0 SSD', '15.6 inch WQHD (2560 x 1440) 16:9, IPS Non-Glare, NanoEdge, DCI-P3:100.00%, 300nits, 240Hz/3ms, Adaptive-Sync', 'RJ45 Ethernet port', 'Wi-Fi 6 (802.11ax)', 'v5.1', 'None', 'Windows® 11 Home', '4 Cell 90WHrs', '2.3 kg', 'Scar Gunmetal', '35.4 x 25.9 x 2.26 ~ 2.72 (cm)', 'https://laptopworld.vn/media/product/10792_asus_rog_strix_scar_15_g533zm_3.jpg'),
('LT01', 'L11', 'Laptop ASUS Zenbook 14 OLED UM3402YA KM405W', 'AMD Ryzen™ 5 7530U Mobile Processor 2.0GHz (6-core/12-thread, 16MB cache, up to 4.5 GHz max boost)', '16GB LPDDR4X on board', 'AMD Radeon™ Graphics', '512GB M.2 NVMe™ PCIe® 3.0 SSD', '14-inch 2.8K (2880 x 1800) OLED 16:10 aspect ratio, 90Hz refresh rate, 600nits peak brightness, 100% DCI-P3 color gamut, VESA CERTIFIED Display HDR True Black 600, 1.07 billion colors, Glossy display, Screen-to-body ratio: 90％', 'Gigabit Ethernet', 'Wi-Fi 6E(802.11ax)', 'v5.3', '1080p FHD camera', 'Windows® 11 Home', '4 Cells 75WHrs', '1.39 kg', 'Jade Black', '31.36 x 22.06 x 1.69 ~ 1.69 cm', 'https://product.hstatic.net/200000722513/product/um3402ya-km405w_76e67c0074d744718702784cd113f4aa_1024x1024.png'), 
('LT02', 'L12', 'Laptop ASUS Zenbook 14 OLED UX3402VA KM203W', 'Intel® Core™ i5-1340P Processor 1.9 GHz (12MB Cache, up to 4.6 GHz, 12 cores, 16 Threads)', '16GB LPDDR5 Onboard 4800 MHz', 'Intel Iris Xe Graphics', '512GB M.2 NVMe™ PCIe® 4.0 SSD', '14-inch WQXGA+ (2880 x 1800) OLED 16:10 aspect ratio, 90Hz refresh rate, 600nits peak brightness, 100% DCI-P3 color gamut, VESA CERTIFIED Display HDR True Black 600, 1.07 billion colors, Glossy display, Screen-to-body ratio: 90％', 'None', 'Wi-Fi 6E(802.11ax)', 'v5.3', '1080p FHD camera', 'Windows® 11 Home', '4 Cells 75WHrs', '1.39 kg', 'Foggy Silver', '31.36 x 22.06 x 1.69 ~ 1.69 cm', 'https://cdn2.fptshop.com.vn/unsafe/1920x0/filters:quality(100)/2023_3_24_638152793095056758_asus-zenbook-ux3402-bac-dd.jpg'), 
('LG11', 'L13', 'Gigabyte AORUS 5 KE4 72VN314SH', 'Intel Core i7-12700H 3.5GHz up to 4.7GHz 24MB', '16GB (8x2) DDR4 3200MHz (2x SO-DIMM socket, up to 64GB SDRAM)', 'NVIDIA® GeForce RTX 3060 Laptop GPU 6GB GDDR6 Boost Clock 1605 MHz, Maximum Graphics Power 115 W', '1TB SSD M.2 PCIE G4X4', '15.6" FHD (1920x1080) IPS-level Anti-glare Display LCD (240Hz, 72% NTSC)', 'RTL8125-BG REALTEK (2.5G) Ethernet', 'Intel® Wi-Fi 6E AX211', 'v5.2', 'HD Camera', 'Windows® 11 Home', '4 Cell 99 WHrs', '2.3kg', '357 x 254 x 23.6~27.4 (mm)', 'Black', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQq3qLqi52s7fAFU9gdf69rLXOiBqyaWPdQdg&s'), 
('LG12', 'L14', 'Gigabyte G5 MF F2VN333SH', 'Intel Core i5-12450H 3.3GHz up to 4.4GHz, 8 Cores 12 Threads, 12MB Cache', '8GB (1x8GB) DDR4-3200Mhz', 'Nvidia Geforce RTX 4050 4GB GDDR6', '512GB SSD M.2 PCIE G4X4', '15.6 inch FHD (1920x1080), 144Hz, IPS-level, Thin Bezel, 45% NTSC', 'Gigabit Ethernet', 'Intel® Wi-Fi 6E', 'HD 720p', 'v5.2', 'Windows® 11 Home', '4 Cell 54Whrs', '1.9kg', '360 x 238 x 22.7 (mm)', 'Black', 'https://anphat.com.vn/media/product/46062_laptop_gigabyte_g5_mf_f2vn333sh_anphatpc6.jpg'), 
('LT05', 'L15', 'Dell Vostro 3530 V5I3465W1', 'Intel Core i3-1305U (3.3GHz~ 4.5GHz) 5 Cores 6 Threads', '8GB (8x1) DDR4 3200MHz (2x SO-DIMM socket, up to 16GB SDRAM)', 'Intel® UHD Graphics', '512GB SSD M.2 PCIE', '15.6 inch FHD (1920 x 1080) 120Hz 250 nits WVA Anti- Glare LED Backlit Narrow Border Display', 'RJ45 Ethernet port', 'Realtek Wi-Fi 5 RTL8821CE', '720p@30FPS HD Camera', 'v5.2', 'Windows 11 Home + Office Home & Student 2021', '3 Cell 41WHr', '1.66kg', '358.5 x 235.56 x 16.96 ~ 18.99 mm', 'Luna Grey', 'https://product.hstatic.net/200000722513/product/ava_323374780a104f079d493a9001f17921_1024x1024.png'), 
('LT03', 'L16', 'Dell Inspiron 15 N3530 I3U085W11BLU', 'Intel Core i3-1305U up to 5.0 GHz, 5 Cores 6 Threads, 10MB Cache', '8GB (1 x 8GB) DDR4 2666MHz (2x SO-DIMM socket, up to 16GB SDRAM)', 'Intel UHD Graphics', '512GB SSD NVMe PCIe', '15.6 Inch FHD (1920 x 1080),120Hz, Anti- Glare, WVA, LED-Backlit, 250 nit', 'None', 'WiFi 802.11ax (Wifi 6)', 'HD Webcam', 'v5.2', 'Windows 11 Home SL + Office Home & Student 2021', '3-cell Li-ion, 41 Whr', '1.60kg', '358.5 x 235.56 x 16.96 mm - 18.99mm', 'Silver', 'https://anphat.com.vn/media/product/44957_laptop_dell_inspiron_3530_n3530_i3u085w11blu.jpg'), 
('LT04', 'L17', 'Lenovo V14 G4 IRU 83A000BHVN', 'Intel® Core™ i5-13420H, 8C (4P + 4E) / 12T, P-core 2.1 / 4.6GHz, E-core 1.5 / 3.4GHz, 12MB', '16GB (2x8GB) DDR4 3200MHz onboard', 'Intel® UHD Graphics', '512GB SSD M.2 2242 PCIe® 4.0x4 NVMe®', '14" FHD (1920x1080) IPS 300nits, Anti-glare, 45% NTSC', 'RJ45 Ethernet port', 'Intel® Wi-Fi 6', 'HD 720p with Privacy Shutter', 'v5.1', 'Windows® 11 Home', 'Integrated 38Wh', '1.43kg', '324.2 x 215.2 x 19.9 mm', 'Iron Grey', 'https://product.hstatic.net/200000722513/product/ava_6809afe39f3141cf9497e2465cbf4d36_1024x1024.png'), 
('LT05', 'L18', 'Lenovo ThinkBook 14 G6 IRL 21KG00RDVN', 'Intel® Core™ i5-13420H, 8C (4P + 4E) / 12T, P-core 2.1 / 4.6GHz, E-core 1.5 / 3.4GHz, 12MB', '16GB (2x8GB) DDR5 5200MHz', 'Integrated Intel® UHD Graphics', '512GB SSD M.2 2242 PCIe® 4.0x4 NVMe® Opal 2.0', '14" WUXGA (1920x1200) IPS 300nits Anti-glare, 45% NTSC', 'RJ45 Ethernet port', 'Wi-Fi® 6E', 'FHD 1080p with Privacy Shutter', 'v5.3', 'Windows® 11 Home', 'Integrated 45Wh', '1.38kg', '313.5 x 224 x 16.9 mm', 'Arctic Grey', 'https://product.hstatic.net/200000722513/product/ava_6b676d21eb834248bad1ccb4a2085909_1024x1024.png'), 
('LT06', 'L19', 'Acer Aspire 5 A515 58GM 598J', 'Intel® Core™ i5-13420H (3.40GHz Up to 4.60Ghz ,8 Cores 12 Threads, 12 MB Intel® Smart Cache)', '16GB (8x2) DDR4 3200MHz', 'NVIDIA® GeForce® RTX™2050 4GB GDDR6', '512GB PCIe NVMe Gen4', '15.6" FHD (1920 x 1080), IPS SlimBezel, 144Hz, Acer ComfyView™, 250 Nits, 45% NTSC', 'RJ45 Ethernet port', 'Wi-Fi 6E AX211', '1080p HD video at 60 fps with Temporal Noise Reduction', 'v5.1', 'Windows® 11 Home', '50Wh Li-ion battery', '1.7kg', '361 x 237 x 17.9 mm', 'Steel Gray', 'https://bizweb.dktcdn.net/thumb/1024x1024/100/329/122/products/laptop-gaming-acer-aspire-5-a515-58gm-598j-01.jpg?v=1718252888973'), 
('LT07', 'L20', 'Acer Aspire 5 A514 56P 55K5', 'Intel® Core™ i5-1335U 1.3GHz up to 4.6GHz 12MB', '16GB LPDDR5 4800MHz', 'Intel® UHD Graphics', '512GB PCIe NVMe SSD', '14" WUXGA (1920 x 1200), IPS SlimBezel, 60Hz, Acer ComfyView™', 'None', 'Intel® Wi-Fi 6', '720p HD video at 30 fps with Temporal Noise Reduction', 'v5.1', 'Windows® 11 Home', '3 Cell 48Whr', '1.5kg', '362.9 x 237.5 x 17.99 (mm)', 'Steel Gray', 'https://cdn2.cellphones.com.vn/x/media/catalog/product/l/a/laptop-acer-aspire-5-a514-56p-55k5_1_.png');


Insert into Headphones(Headphoneid,HeadphoneName,brand,model,Features,connection,battery_life,
noise_cancel,price,img,description,ProductID) Values
(N'H1',N'Tai nghe Bluetooth True Wireless HUAWEI','HUAWEI',N'Tai nghe không dây',N'Chống ồn , Có mic đàm thoại ','Bluetooth',N'8 giờ',N'Có chồng ồn',3490000,'https://cdn2.cellphones.com.vn/x/media/catalog/product/t/a/tai-nghe-khong-day-huawei-freeclip-.png','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',21),
(N'H2',N'Tai nghe Bluetooth Apple AirPods Pro 2 2023 USB-C','Apple',N'Tai nghe không dây',N'Chống ồn , Có mic đàm thoại ','Bluetooth',N'8 giờ',N'Có chồng ồn',3490000,'https://cdn2.cellphones.com.vn/x/media/catalog/product/t/a/tai-nghe-khong-day-huawei-freeclip-.png','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',22),
(N'H3',N'Tai nghe Bluetooth chụp tai Sony WH-CH520','Sony ',N'Tai nghe chụp',N'Sạc Nhanh, Có mic đàm thoại','Bluetooth',N'8 giờ',N'Có chồng ồn',1090000,'https://cdn2.cellphones.com.vn/x/media/catalog/product/t/a/tai-nghe-chup-tai-sony-wh-ch520-_2_.png','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',23),
(N'H4',N'Tai nghe Bluetooth chụp tai Baseus Bass 35 Max','Baseus',N'Tai nghe không dây',N'Chống ồn , Có mic đàm thoại ','Bluetooth',N'8 giờ',N'Có chồng ồn',585000,'https://cdn2.cellphones.com.vn/x/media/catalog/product/t/a/tai-nghe-chup-tai-baseus-bass-35-max_3_.png','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',24),
(N'H5',N'Tai nghe Bluetooth True Wireless Xiaomi Redmi Buds 6 Active','Xiaomi ',N'Tai nghe không dây',N'Chống ồn , Có mic đàm thoại ','Bluetooth',N'8 giờ',N'Có chồng ồn',590000,'https://cdn2.cellphones.com.vn/x/media/catalog/product/t/a/tai-nghe-bluetooth-xiaomi-redmi-buds-6-active_1_.png','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',25),
(N'H6',N'Tai nghe có dây JBL Tune 310C','JBL ', N'Tai nghe có dây',N'Chống ồn , Có mic đàm thoại ','Cắm dây',N'8 giờ',N'Có chồng ồn',590000,'https://cdn2.cellphones.com.vn/x/media/catalog/product/t/a/tai-nghe-jbl-tune-310c-3.png','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',26),
(N'H7',N'Tai nghe KZ ZSN Pro X','ZSN ',N'Tai nghe có dây',N'Chống ồn , Có mic đàm thoại ','Cắm dây',N'8 giờ',N'Có chồng ồn',590000,'https://cdn2.cellphones.com.vn/x/media/catalog/product/k/z/kz_zsn_pro_x_1.png','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',27),
(N'H8',N'Tai nghe có dây Gaming Havit H2015E','Havit ',N'Tai nghe có dây',N'Chống ồn , Có mic đàm thoại ','Bluetooth',N'8 giờ',N'Có chồng ồn',550000,'https://cdn2.cellphones.com.vn/x/media/catalog/product/t/a/tai-nghe-co-day-havit-h2015e_6_.png','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',28),
(N'H9',N'TAI NGHE APPLE EARPODS CỔNG LIGHTNING CHÍNH HÃNG','APPLE ',N'Tai nghe không dây',N'Chống ồn , Có mic đàm thoại ','Bluetooth',N'8 giờ',N'Có chồng ồn',500000,'https://cdn2.cellphones.com.vn/x/media/catalog/product/f/r/frame_3_3.png','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',29),
(N'H10',N'Tai nghe Apple EarPods USB-C MTJY3ZA/A','Apple ',N'Tai nghe không dây',N'Chống ồn , Có mic đàm thoại ','Bluetooth',N'8 giờ',N'Có chồng ồn',550000,'https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/t/a/tai-nghe-apple-earpods-usb-c_1_.png','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',30),

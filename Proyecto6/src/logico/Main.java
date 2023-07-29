package logico;

public class Main {

	public static void main(String[] args) {
		
		Tienda tienda = new Tienda();
		
		//PROCESADORES:

		Producto mp1 = new Microprocesador("Intel", "Core i7 6700K", 12000, 20, "00000001", "Microprocesador", "4.20GHZ", "LGA1151");
		Producto mp2 = new Microprocesador("Intel", "CORE i5-13400", 13248, 20, "00000005", "Microprocesador", "2.5GHZ to 4.5GHZ", "LGA1700");
		Producto mp3 = new Microprocesador("Ryzen", "AMD Ryzen 9 5950X", 26199, 7, "00000011", "Microprocesador", "4.9GHZ", "AM4");
		Producto mp4 = new Microprocesador("Ryzen", "AMD Ryzen 5 5600X", 8599, 25, "00000012", "Microprocesador", "4.6GHZ", "AM4");

		tienda.AgregarProducto(mp1);
		tienda.AgregarProducto(mp2);
		tienda.AgregarProducto(mp3);
		tienda.AgregarProducto(mp4);
		
		//TARJETAS MADRE:
		
		Producto tm1 = new TarjetaMadre("ASUS", "ROG MAXIMUS Z790 HERO EVA-02 EDITION", 20000, 15, "00000002", "Motherboard", "LGA1700", "DDR5", "SATA 3");
		Producto tm2 = new TarjetaMadre("GIGABYTE", "B650 AORUS AX", 14500, 10, "00000006", "Motherboard", "AM5", "DDR5", "SATA 3");
		Producto tm3 = new TarjetaMadre("ASUS", "ROG Strix Z590-E", 12199, 25, "00000015", "Motherboard", "LGA1200", "DDR4", "SATA 2");
		Producto tm4 = new TarjetaMadre("MSI", "MPG B550 GAMING EDGE WIFI", 9399, 15, "00000016", "Motherboard", "AM4", "DDR4", "SATA");
		Producto tm5 = new TarjetaMadre("GIGABYTE", "B365M DS3H", 5299, 30, "00000017", "Motherboard", "LGA1151", "DDR4", "SATA");
		
		tienda.AgregarProducto(tm1);
		tienda.AgregarProducto(tm2);
		tienda.AgregarProducto(tm3);
		tienda.AgregarProducto(tm4);
		tienda.AgregarProducto(tm5);
		
		//MEMORIAS RAM:
		
		Producto ram1 = new MemoriaRAM("Corsair", "CORSAIR VENGEANCE RGB", 3000, 30, "00000003", "MemoriaRAM", 16, "DDR5");
		Producto ram2 = new MemoriaRAM("Corsair", "VENGEANCE LPX DDR4", 2299, 45, "00000007", "MemoriaRAM", 16, "DDR4");
		Producto ram3 = new MemoriaRAM("HyperX", " HyperX Fury DDR4", 1299, 50, "00000013", "MemoriaRAM", 8, "DDR4");
		Producto ram4 = new MemoriaRAM("G.Skill", "G.Skill Ripjaws V", 3999, 25, "00000014", "MemoriaRAM", 32, "DDR4");
		
		tienda.AgregarProducto(ram1);
		tienda.AgregarProducto(ram2);
		tienda.AgregarProducto(ram3);
		tienda.AgregarProducto(ram4);
		
		//DISCOS DUROS:
		
		Producto dd1 = new DiscoDuro("WESTERN DIGITAL", "WDS100T3B0A", 3000, 100, "00000004", "DiscoDuro", "1TB", "SATA 3");
		Producto dd2 = new DiscoDuro("SAMSUNG", "870 EVO", 2799, 50, "00000008", "DiscoDuro", "1TB", "SATA 3");
		Producto dd3 = new DiscoDuro("PNY", "PNY CS900", 2499, 35, "00000009", "DiscoDuro", "1TB", "SATA 3");
		Producto dd4 = new DiscoDuro("Kingston", "Kingston SSD", 1319, 100, "00000010", "DiscoDuro", "240GB", "SATA");
		
		tienda.AgregarProducto(dd1);
		tienda.AgregarProducto(dd2);
		tienda.AgregarProducto(dd3);
		tienda.AgregarProducto(dd4);
		
		//COMBOS:
		
		Combo combo1 = new Combo("Ryzen 5600x + MPG B550 + G.Skill 32GB x2", mp4, tm4, ram4, ram4, null, null);
		Combo combo2 = new Combo("Z790 + Vengeance RGB DDR5 x2", tm1, ram1, ram1, null, null, null);
		Combo combo3 = new Combo("i7 6700k + SAMSUNG 870 EVO x2 + B365M DS3H", mp1, dd2, dd2, tm5, null, null);
		
		tienda.AgregarCombo(combo1);
		tienda.AgregarCombo(combo2);
		tienda.AgregarCombo(combo3);
		

	    tienda.BuscarProducto("00000002");
	    
	    //CLIENTES:

		Cliente c1 = new Cliente("Luis", "Gonzalez", "Avenida Estrella Sadhalá", "8092788917");
		Cliente c2 = new Cliente("Juan", "Lopez", "Valle Verde", "8492878311");
		
		tienda.AgregarCliente(c1);
		tienda.AgregarCliente(c2);
		
		c1.agregarProductoAlCarrito(ram1, 2);
		c1.agregarProductoAlCarrito(tm1, 1);
		c1.agregarProductoAlCarrito(mp1, 1);
		
		c1.agregarComboAlCarrito(combo1, 1);
		c1.agregarComboAlCarrito(combo2, 1);
		
		c1.verCarritoCompleto();
		
		c1.realizarCompra();

	}

}

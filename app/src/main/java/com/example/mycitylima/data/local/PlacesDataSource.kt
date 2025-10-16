package com.example.mycitylima.data.local

import com.example.mycitylima.data.model.Category
import com.example.mycitylima.data.model.Place

object PlacesDataSource {
    fun getPlaces(): List<Place> = listOf(
        // Restaurantes
        Place(
            id = 1,
            name = "Central Restaurante",
            category = Category.RESTAURANTS,
            description = "Reconocido internacionalmente, Central es el restaurante insignia del chef Virgilio Martínez. Ofrece una experiencia culinaria única que explora la biodiversidad del Perú a través de ingredientes de diferentes altitudes, desde el océano hasta los Andes.",
            imageUrl = "https://images.unsplash.com/photo-1414235077428-338989a2e8c0?w=800",
            address = "Av. Pedro de Osma 301, Barranco",
            rating = 4.9
        ),
        Place(
            id = 2,
            name = "Maido",
            category = Category.RESTAURANTS,
            description = "El restaurante del chef Mitsuharu Tsumura combina la cocina japonesa con ingredientes peruanos. Famoso por su innovador menú nikkei, Maido ha sido clasificado entre los mejores restaurantes del mundo.",
            imageUrl = "https://images.unsplash.com/photo-1579027989536-b7b1f875659b?w=800",
            address = "Calle San Martín 399, Miraflores",
            rating = 4.8
        ),
        Place(
            id = 3,
            name = "La Mar Cebichería",
            category = Category.RESTAURANTS,
            description = "Del chef Gastón Acurio, La Mar es el lugar perfecto para disfrutar del mejor ceviche de Lima. Ambiente casual frente al mar, con pescados y mariscos frescos preparados con la técnica tradicional peruana.",
            imageUrl = "https://images.unsplash.com/photo-1519708227418-c8fd9a32b7a2?w=800",
            address = "Av. Mariscal La Mar 770, Miraflores",
            rating = 4.7
        ),
        Place(
            id = 4,
            name = "Osso Carnicería y Salumeria",
            category = Category.RESTAURANTS,
            description = "Especializado en carnes de alta calidad y charcutería artesanal. Osso ofrece cortes premium y una selección de embutidos preparados en casa, en un ambiente rústico y acogedor.",
            imageUrl = "https://images.unsplash.com/photo-1544025162-d76694265947?w=800",
            address = "Av. Conquistadores 598, San Isidro",
            rating = 4.6
        ),

        // Atracciones
        Place(
            id = 5,
            name = "Huaca Pucllana",
            category = Category.ATTRACTIONS,
            description = "Sitio arqueológico precolombino construido por la cultura Lima entre los años 200 y 700 d.C. Esta gran pirámide de adobe y arcilla se encuentra en el corazón de Miraflores y ofrece tours nocturnos espectaculares.",
            imageUrl = "https://images.unsplash.com/photo-1587974928442-77dc3e0dba72?w=800",
            address = "Calle General Borgoño cuadra 8, Miraflores",
            rating = 4.5
        ),
        Place(
            id = 6,
            name = "Circuito Mágico del Agua",
            category = Category.ATTRACTIONS,
            description = "Complejo de fuentes ornamentales que ostenta el récord Guinness del complejo de fuentes más grande del mundo. Por las noches, las fuentes se iluminan y realizan un espectáculo de luz, agua y música impresionante.",
            imageUrl = "https://images.unsplash.com/photo-1547036967-23d11aacaee0?w=800",
            address = "Parque de la Reserva, Cercado de Lima",
            rating = 4.4
        ),
        Place(
            id = 7,
            name = "Centro Histórico de Lima",
            category = Category.ATTRACTIONS,
            description = "Patrimonio de la Humanidad por la UNESCO, el centro histórico incluye la Plaza Mayor, la Catedral de Lima, el Palacio de Gobierno y la Basílica de San Francisco con sus famosas catacumbas.",
            imageUrl = "https://images.unsplash.com/photo-1531968455001-5c5272a41129?w=800",
            address = "Plaza Mayor, Cercado de Lima",
            rating = 4.7
        ),
        Place(
            id = 8,
            name = "Puente de los Suspiros",
            category = Category.ATTRACTIONS,
            description = "Icónico puente de madera en Barranco que conecta dos calles sobre una quebrada. Según la leyenda, quien cruza el puente conteniendo la respiración verá cumplido su deseo. Rodeado de arquitectura colonial y cafés bohemios.",
            imageUrl = "https://images.unsplash.com/photo-1519046904884-53103b34b206?w=800",
            address = "Bajada de Baños, Barranco",
            rating = 4.6
        ),

        // Parques
        Place(
            id = 9,
            name = "Parque Kennedy",
            category = Category.PARKS,
            description = "El corazón de Miraflores, famoso por sus gatos callejeros bien cuidados. Un lugar vibrante rodeado de cafés, tiendas y artesanos. Perfecto para observar a la gente y disfrutar del ambiente local.",
            imageUrl = "https://images.unsplash.com/photo-1519331379826-f10be5486c6f?w=800",
            address = "Av. Larco, Miraflores",
            rating = 4.3
        ),
        Place(
            id = 10,
            name = "Malecón de Miraflores",
            category = Category.PARKS,
            description = "Espectacular paseo a lo largo del acantilado con vistas panorámicas al Océano Pacífico. Ideal para correr, andar en bicicleta o simplemente contemplar la puesta del sol. Incluye el Parque del Amor con su famosa escultura 'El Beso'.",
            imageUrl = "https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=800",
            address = "Malecón Cisneros, Miraflores",
            rating = 4.8
        ),
        Place(
            id = 11,
            name = "Parque de la Reserva",
            category = Category.PARKS,
            description = "Hogar del Circuito Mágico del Agua, este parque ofrece amplias áreas verdes, senderos para caminar y jardines. Es uno de los parques más grandes del centro de Lima y un lugar ideal para actividades al aire libre.",
            imageUrl = "https://images.unsplash.com/photo-1571939228382-b2f2b585ce15?w=800",
            address = "Jr. Madre de Dios, Cercado de Lima",
            rating = 4.4
        ),

        // Museos
        Place(
            id = 12,
            name = "Museo Larco",
            category = Category.MUSEUMS,
            description = "Museo privado de arte precolombino ubicado en una mansión virreinal del siglo XVIII. Alberga una impresionante colección de más de 45,000 piezas de cerámica, textiles y orfebrería de culturas peruanas antiguas.",
            imageUrl = "https://images.unsplash.com/photo-1565374218006-a4afe9d82d1a?w=800",
            address = "Av. Bolívar 1515, Pueblo Libre",
            rating = 4.8
        ),
        Place(
            id = 13,
            name = "MALI - Museo de Arte de Lima",
            category = Category.MUSEUMS,
            description = "Principal museo de arte del Perú, exhibe 3,000 años de historia artística peruana. Desde arte precolombino hasta obras contemporáneas, el MALI ofrece un recorrido completo por la cultura visual del país.",
            imageUrl = "https://images.unsplash.com/photo-1582555172866-f73bb12a2ab3?w=800",
            address = "Paseo Colón 125, Cercado de Lima",
            rating = 4.6
        ),
        Place(
            id = 14,
            name = "Museo Nacional de Arqueología",
            category = Category.MUSEUMS,
            description = "Dedicado a la exhibición y preservación del patrimonio arqueológico peruano. Muestra artefactos de todas las culturas precolombinas, incluyendo cerámica, textiles y objetos ceremoniales.",
            imageUrl = "https://images.unsplash.com/photo-1566127444979-b3d2b68d08e6?w=800",
            address = "Plaza Bolívar, Pueblo Libre",
            rating = 4.5
        ),

        // Compras
        Place(
            id = 15,
            name = "Larcomar",
            category = Category.SHOPPING,
            description = "Centro comercial al aire libre construido en un acantilado con vistas espectaculares al océano. Combina tiendas internacionales, restaurantes con vista al mar, cines y espacios de entretenimiento en un entorno único.",
            imageUrl = "https://images.unsplash.com/photo-1441986300917-64674bd600d8?w=800",
            address = "Malecón de la Reserva 610, Miraflores",
            rating = 4.6
        ),
        Place(
            id = 16,
            name = "Jockey Plaza",
            category = Category.SHOPPING,
            description = "Uno de los centros comerciales más grandes de Lima, con más de 300 tiendas de marcas internacionales y locales. Incluye áreas de comida, cines, zonas de entretenimiento y está ubicado estratégicamente en Santiago de Surco.",
            imageUrl = "https://images.unsplash.com/photo-1519567241046-7f570eee3ce6?w=800",
            address = "Av. Javier Prado Este 4200, Surco",
            rating = 4.5
        ),
        Place(
            id = 17,
            name = "Mercado Indio de Miraflores",
            category = Category.SHOPPING,
            description = "Mercado artesanal donde encontrarás auténticas artesanías peruanas: textiles de alpaca, cerámica, joyería de plata, instrumentos musicales andinos y souvenirs tradicionales. Ideal para comprar regalos únicos.",
            imageUrl = "https://images.unsplash.com/photo-1557821552-17105176677c?w=800",
            address = "Av. Petit Thouars 5245, Miraflores",
            rating = 4.3
        )
    )

    fun getCategories(): List<Category> = Category.values().toList()

    fun getPlacesByCategory(category: Category): List<Place> =
        getPlaces().filter { it.category == category }
}
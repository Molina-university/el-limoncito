
# Lavandería “El Limoncito”


Cada tarde, El Limoncito recibe clientes que dejan su ropa para recoger el mismo día. El módulo debe registrar nombre y teléfono del cliente y crear una orden con ítems de un catálogo fijo de hoy: Camisa ($4.000, o $3.500 c/u si dejan 5 o más), Pantalón ($6.000, o $5.000 c/u desde 5), y Chaqueta ($9.000, o $7.500 c/u desde 5). El cliente puede marcar la opción “servicio exprés”, que agrega un recargo del 10% al total. El cálculo debe hacerse así: primero subtotales por ítem usando precio por volumen cuando aplique; luego sumar para obtener el total bruto; si es exprés, agregar el 10%; al final, si el total resultante supera $60.000, aplicar descuento del 5% (una sola vez). No se permiten cantidades ≤ 0 ni totales negativos. Al confirmar la orden, no se puede editar y se debe generar un resumen claro (cliente, detalle con precio aplicado, total bruto, recargo, descuento y total final). No hay pagos ni inventario: solo tomar la orden, calcular y confirmar para agilizar la entrega.

---

# Requerimientos funcionales

- RF1: registrar nombre y telefono
- RF2: mostrar un catalogo al cliente
- RF3: calcular el precio dependiendo del catalogo y la cantidad
- RF4: verificar si el total es mayor a 60.000 aplicar 5% de descuento 1 vez 
- RF5: confirmar el pedido
- RF5: generar resumen de la compra (con los datos del cliente, el total y los extras y descuentos aplicados)

- Requerimiento opcional: mostrar eleccion entre servicio expres o normal (se agrega un 10% extra al total)
- Requerimiento opcional 2: verificar si selecciono servicio expres, si lo selecciono sumar lo del punto 3

---

# reglas de negocio

R1: si cantidad de productos > 6, el precio por producto se reduce dependiendo del producto en cuestion 
R2: si servicio expres es seleccionado se agrega un 10% al total de la cuenta
R3: si precio total supera los 60000 sin contar el recargo del servicio expres reducir un 5% el total de la cuenta
R4: no puede haber precios negativos y ni cantidades negativas
R5: nombre, telefono y descuentos no pueden ser nulos ni negativos ni con caracteres especiales 

--- 

# Criterios de aceptacion
-

## Registro de cliente

  Escenario: Registrar cliente válido
    Dado que el sistema necesita registrar un nuevo cliente
    Cuando ingreso "Juan Pérez" como nombre y "123456789" como teléfono
    Entonces el sistema registra exitosamente el cliente

  Escenario: Nombre inválido
    Dado que el sistema necesita registrar un nuevo cliente
    Cuando ingreso "" como nombre y "123456789" como teléfono
    Entonces el sistema muestra error "Nombre no puede estar vacío"

  Escenario: Teléfono inválido
    Dado que el sistema necesita registrar un nuevo cliente
    Cuando ingreso "Juan Pérez" como nombre y "" como teléfono
    Entonces el sistema muestra error "Teléfono no puede estar vacío"

## Selección de Productos

Escenario: Agregar camisas con descuento por volumen
    Dado que estoy creando una nueva orden
    Cuando agrego 6 camisas
    Entonces el precio unitario es $3500

  Escenario: Agregar pantalones con descuento por volumen
    Dado que estoy creando una nueva orden
    Cuando agrego 5 pantalones
    Entonces el precio unitario es $5000

  Escenario: Agregar chaquetas con descuento por volumen
    Dado que estoy creando una nueva orden
    Cuando agrego 5 chaquetas
    Entonces el precio unitario es $7500

## Servicio Exprés

 Escenario: Aplicar recargo de servicio exprés
    Dado que tengo una orden con total bruto de $30000
    Cuando selecciono servicio exprés
    Entonces se agrega un recargo del 10% al total

  Escenario: Servicio exprés con múltiples productos
    Dado que tengo una orden con varios productos
    Cuando selecciono servicio exprés
    Entonces el recargo del 10% solo se aplica una vez al total

## Descuentos y Totales

Escenario: Aplicar descuento por total superior a $60000
    Dado que tengo una orden con total de $70000
    Cuando el sistema calcula los descuentos finales
    Entonces se aplica un descuento del 5% al total final

  Escenario: No aplicar descuento por total inferior a $60000
    Dado que tengo una orden con total de $50000
    Cuando el sistema calcula los descuentos finales
    Entonces no se aplica ningún descuento adicional

  Escenario: Combinación de descuentos
    Dado que tengo una orden con total de $80000
    Y he seleccionado servicio exprés
    Cuando el sistema calcula todos los ajustes
    Entonces primero aplica el recargo exprés y luego el descuento del 5%

## Confirmación y Resumen

  Escenario: Generar resumen completo
    Dado que tengo una orden válida
    Cuando confirmo la orden
    Entonces el sistema muestra un resumen con:
      - Datos del cliente
      - Detalle de productos con precios
      - Subtotales y totales
      - Descuentos aplicados
      - Recargos si corresponden
      - Total final

  Escenario: No permitir modificaciones después de confirmar
    Dado que he confirmado una orden
    Cuando intento modificar algún producto
    Entonces el sistema muestra error "No se pueden realizar cambios en órdenes confirmadas
---

# limite de diseño (clases que haran que esto funcione )
- 1. cliente 
- 2. itemPedido 
- 3. Pedido
- 4. Producto
- 5. Limoncito 
- 6. app.java

--- 

# Flujo de consola

- 1. ingresar cliente
- 2. crear pedido
- 3. seleccionar producto y cantidad del producto 
- 4. seleccionar si desea el servicio expres o no
- 5. confirmar pedido
- 6. mostrar resumen de la cuenta generada con los descuentos y extras aplicados

---

# Estructura general del proyecto 

```
EL-LIMONCITO/
│
├── assets/                      # Recursos del proyecto
│   ├── image.png               # Imágenes
│   ├── README.md               # Documentación de assets
│   └── UML.jpg                 # Diagramas UML
│
├── bin/                        # Archivos compilados (.class)
│
├── src/                        # Código fuente
│   ├── app/                    # Capa de aplicación
│   │   └── App.java           # Clase principal
│   │
│   └── domain/                 # Capa de dominio (lógica de negocio)
│       ├── Cliente.java       # Entidad Cliente
│       ├── ImpPedido.java     # Implementación de Pedido
│       ├── Pedido.java        # Entidad Pedido
│       └── Producto.java      # Entidad Producto
│
├── view/                       # Capa de presentación
│   └── Limoncito.java         # Interfaz de usuario
│
├── .gitignore                  # Archivos ignorados por Git
└── README.md                   # Documentación principal
```
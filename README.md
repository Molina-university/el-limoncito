
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

## */RF1/*
CA1: crear nombre y telefono 
CA2: verificar que no sean nulos o posean caracteres especiales

## */RF2/*
CA3: mostrar los objetos a la venta con su respectivo precio 

## */RF3/*
CA4: calcular el precio total de todo el pedido y aplicar el descuento o el extra correspondiente
CA5: verificar que el extra o el descuento realizado se aplique solo una vez a cada compra general (es decir, solo en el total)
CA6: verificar si la cantidad ingresada por el usuario es > 0
CA7: verificar que descuento no sea negativo
CA8: verificar que los descuentos por cantidad de productos solo se apliquen cuando se agregen 5 unidades o mas de cada producto

## */RF4/*
CA9: si suma del total del pedido > 60.000 aplicar descuento del 5% al total
CA10: verificar que descuento no sea negativo
CA11: verificar que descuento no se aplique mas de una sola vez o que no se aplique a cada producto por individual

## */RF5/*
CA12: al confirmar el pedido no se puede alterar el pedido confirmado
CA13: al confirmar el pedido debe de realizar todos los calculos y reunirlos en el ticket final

## */RF6/*
CA14: mostrar resumen de compra con datos de cliente, detalles de productos con precios, descuentos y exztras si aplican y total final
CA15: verificar que resumen de compra no muestre mas de 1 vez el pedido o muestre valores negativos


## */Requerimiento opcional/*
CA1.1: mostrar por pantalla una validacion para confirmar si el usuario desea o no el servicio expres
CA1.2: si CA4 es true, agregar el 10% 
CA1.3: validar que la respuesta dada no sea nula o de cualquier otro caracter 

## */Requerimiento opcional 2/*
CA2.1: la suma del 10% debe hacerce al total del pedido
CA2.2: el extra solo se puede añadir 1 vez a la cuenta

---

# limite de diseño (clases que haran que esto funcione )
- 1. cliente 
- 2. itemPedido 
- 3. Pedido
- 4. Producto
- 5. Limoncito 

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

/El limoncito/


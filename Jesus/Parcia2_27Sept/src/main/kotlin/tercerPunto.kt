class SuperList<T> {
    class Nodo<T>(var info: Int, var sig: Nodo<T>? = null)
    private var prim: Nodo<T>? = null
    fun invertir() {
        // Primer paso
        var x = prim
        var z: Nodo<T>? = null
        prim = null

        // Segundo paso
        z = x!!.sig

        // Tercer paso
        x!!.sig = prim

        // Cuarto paso
        prim = x
        x = z

        while (x != null) {
            z = x.sig           // segundo paso
            x.sig = prim        // tercer paso
            prim = x            // cuarto paso
            x = z               // cuarto paso
        }
    }
}
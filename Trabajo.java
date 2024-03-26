
    package com.mycompany.juegorpg;

    /**
     *
     * @author cristian
     */
    // Clase para representar un trabajo
      class Trabajo {
        String nombre;
        String habilidadEspecial;
        double fuerzaMod;
        double velocidadMod;
        double defensaMod;

        // Constructor
        public Trabajo(String nombre, String habilidadEspecial, double fuerzaMod, double velocidadMod, double defensaMod) {
            this.nombre = nombre;
            this.habilidadEspecial = habilidadEspecial;
            this.fuerzaMod = fuerzaMod;
            this.velocidadMod = velocidadMod;
            this.defensaMod = defensaMod;
        }
    }

    // Clase para representar un personaje
    class Personaje {
        String nombre;
        Trabajo trabajoActivo;
        Trabajo[] trabajosAsignados = new Trabajo[2]; // Cada personaje puede tener hasta 2 trabajos asignados

        // Constructor
        public Personaje(String nombre) {
            this.nombre = nombre;
        }

        // Método para cambiar el trabajo activo
        public void cambiarTrabajoActivo(int indice) {
            if (indice >= 0 && indice < trabajosAsignados.length) {
                trabajoActivo = trabajosAsignados[indice];
                System.out.println(nombre + " cambió su trabajo activo a " + trabajoActivo.nombre);
            } else {
                System.out.println("Índice de trabajo fuera de rango.");
            }
        }
    }




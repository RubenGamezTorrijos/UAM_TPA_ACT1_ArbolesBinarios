# 🌳 Juego Árboles Binarios
## Simulación de combate por turnos con árbol binario de habilidades en Java
![UAM_TPA_ArbolHabilidades_Logo](https://upload.wikimedia.org/wikipedia/commons/7/7e/Skill_tree_example_diagram.svg)

![Status](https://img.shields.io/badge/Estado-En%20Desarrollo-yellowgreen?style=flat-square)
![GitHub license](https://img.shields.io/github/license/usuario/JuegoArbolHabilidades?style=flat-square)
![GitHub version](https://img.shields.io/github/v/tag/usuario/JuegoArbolHabilidades?label=versión&style=flat-square)
![GitHub repo size](https://img.shields.io/github/repo-size/usuario/JuegoArbolHabilidades?style=flat-square)
![GitHub Repo stars](https://img.shields.io/github/stars/usuario/JuegoArbolHabilidades?style=social)

![GitHub issues](https://img.shields.io/github/issues/usuario/JuegoArbolHabilidades?style=flat-square)
![GitHub forks](https://img.shields.io/github/forks/usuario/JuegoArbolHabilidades?style=flat-square)
![GitHub last commit](https://img.shields.io/github/last-commit/usuario/JuegoArbolHabilidades?style=flat-square)

> [!NOTE]
> - **Versión actual:** 1.0.0  
> - **Plataforma:** Java (consola)  
> - **Compatibilidad:** Windows, macOS, Linux

**Juego Árbol de Habilidades** es una aplicación de consola en Java que simula un árbol binario de habilidades para personajes tipo RPG. Cada jugador cuenta con habilidades ofensivas y defensivas, que se desbloquean, mejoran y utilizan estratégicamente en turnos, consumiendo energía y considerando cooldowns.

---

## 📋 Índice
- [🎮 Características](#-características)
- [🌳 Captura de Árbol](#-captura-de-árbol)
- [📁 Estructura del Proyecto](#-estructura-del-proyecto)
- [🛠 Instalación y Ejecución](#-instalación-y-ejecución)
- [👥 Uso del Juego](#-uso-del-juego)
- [🤝 Contribuciones](#-contribuciones)
- [🎓 Créditos](#-créditos)
- [📜 Licencia](#-licencia)

---

## 🎮 Características

### 🌿 Sistema de árbol binario
- Habilidades ofensivas y defensivas en ramas izquierda/derecha.
- Estructura de profundidad 4 por jugador.

### 💥 Combate por turnos
- Alternancia entre dos jugadores.
- Gestión de energía por turno.
- Cooldowns por habilidad.

### 🔧 Gestión dinámica
- Mejora de habilidades si cumple requisitos.
- Uso condicional: requiere energía y no estar en cooldown.

### 💾 Guardado y carga
- Guarda árbol actual en `.txt`.
- Carga el estado de un árbol desde archivo.

### 🧠 Inteligencia simple del oponente
- El jugador contrario actúa automáticamente si se desea.

---

## 🌳 Captura de Árbol
![{7A747511-E530-40F2-A991-BF4DF6A93523}](https://github.com/user-attachments/assets/046e4564-9210-4335-bf62-3f9bd43c7a7d)

```
- Maestría (Nv: 1/3, Cooldown: 0, Restante: 0)
  - Espada (Nv: 1/3, Cooldown: 2, Restante: 0)
  - Escudo (Nv: 0/3, Cooldown: 1, Restante: 1)
```

> Las habilidades se muestran en árbol binario con niveles y estados.

---

## 📁 Estructura del Proyecto

```
JuegoArbolHabilidades/
├── src/
│   ├── Habilidad.java
│   ├── NodoHabilidad.java
│   ├── ArbolHabilidades.java
│   ├── Jugador.java
│   └── Main.java
├── README.md
└── Memoria_Tecnica_Juego_Arbol_Habilidades.docx
```

## 🚀 Configuración inicial

Bienvenido al mundo de Java en VS Code. Aquí tienes una guía para ayudarte a empezar a escribir código Java en Visual Studio Code.

### 📂 Estructura de directorios

El espacio de trabajo contiene dos carpetas de forma predeterminada, donde:

- `src`: la carpeta para mantener las fuentes
- `lib`: la carpeta para mantener las dependencias

Mientras tanto, los archivos de salida compilados se generarán en el `bin` carpeta por defecto.

> Si desea personalizar la estructura de carpetas, abra `.vscode/settings.json` y actualice la configuración relacionada allí.

### 📦 Configurar dependencias

`JAVA PROJECTS` La vista le permite administrar sus dependencias. Puede encontrar más detalles. [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

---

## 🛠 Instalación y Ejecución

### 🔹 Requisitos previos
- Java JDK 17 o superior
- VS Code o cualquier editor con terminal Java

### 🔹 Paso a paso

1. **Clona o descarga el repositorio**
2. **Abre terminal en la carpeta `src/`**
3. **Compila todo:**
   ```bash
   javac *.java
   ```
4. **Ejecuta:**
   ```bash
   java Main
   ```

---

## 👥 Uso del Juego

1. Se alternan turnos entre Jugador 1 y Jugador 2.
2. Cada jugador puede:
   - Ver su árbol de habilidades.
   - Usar habilidades disponibles.
   - Mejorar habilidades si cumple requisitos.
   - Pasar turno y regenerar energía.
   - Ver estado del oponente.
3. También puede guardar y cargar su árbol desde archivos `.txt`.

---

## 🤝 Contribuciones

¿Quieres mejorar el proyecto o añadir nuevas funcionalidades?

1. Haz un fork.
2. Crea una rama (`feature/nombre`).
3. Sube tus cambios (`git commit` + `git push`).
4. Abre un Pull Request.

---

## 🎓 Créditos

- **Rubén Gámez Torrijos** — Coordinación, desarrollo y arquitectura lógica del juego. UAM TPA Actividad 1 - Árboles Binarios.

---

## 📜 Licencia

Este proyecto está licenciado bajo la [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).

---

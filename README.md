<div align="center">
    <img src="https://github.com/user-attachments/assets/bd7d8c4a-4267-4107-922c-89979ba8e5c6" height="370px">
</div>

Serpent is a classic snake game built with JavaFX and Maven. This project was designed to be modular, interactive, and fun while improving my understanding of game loops, event handling, and UI development. 

### Features
- Smooth movement & collision detection
- Classic snake mechanics with score tracking
- JavaFX UI with animations
- Modular and maintainable game logic

### Prerequisites
Before running the game, ensure you have:  
- Java 17 or later installed (`java -version` to check).  
- Maven installed (`mvn -version` to check).  
- JavaFX SDK 17, which you can download from:  
    [https://gluonhq.com/products/javafx/](https://gluonhq.com/products/javafx/)

### Project Setup
1. Download and extract JavaFX SDK 17
   - Place the extracted `javafx-sdk-17` inside the project folder (where `pom.xml` is).  

2. Clone or download the project
   ```sh
   git clone https://github.com/your-repo/serpent-game.git
   cd serpent-game
   ```

3. Build the project with Maven
   ```sh
   mvn clean package
   ```
   
### Running the Game
After building the project, run the following command:
```sh
java --module-path "javafx-sdk-17/lib" --add-modules javafx.controls,javafx.fxml -jar target/serpent-game-1.0-SNAPSHOT.jar
```
Make sure the path to JavaFX SDK is correct based on where you placed it.

### Contributers
<table>
  <tr>
    <td align="center" style="height: 180px; text-align: center;">
      <img src="https://secure.gravatar.com/avatar/8ec9f21076f59c2e75e6a41a0f14361de5725da8c4440feb792b33da8d010f03?s=384&d=identicon" width="100px;"/>
      <br/><sub><b>Asim</b></sub><br>@mehmetas
    </td>
    <td align="center" style="height: 180px; text-align: center;">
      <img src="https://secure.gravatar.com/avatar/ecab705c9ae5eb55f9d0f6573475184e7865f7efdf2c80e782a1e06ba27088b8?s=48&d=identicon" width="100px;"/>
      <br/><sub><b>Erik</b></sub><br>@eriknis
    </td>
    <td align="center" style="height: 180px; text-align: center;">
      <img src="https://secure.gravatar.com/avatar/d9399696f23a96d7eb2cf9e527b8a4897526f4d93aea9ee32c8a6f70fa29af36?s=384&d=identicon" width="100px;"/>
      <br/><sub><b>Rizwan</b></sub><br>@rizwanra
    </td>
    <td align="center" style="height: 180px; text-align: center;">
      <img src="https://secure.gravatar.com/avatar/3271ba4e481b7c393b650b96a17344d0?s=800&d=identicon" width="100px;"/>
      <br/><sub><b>Marko</b></sub><br>@mojsov
    </td>
    <td align="center" style="height: 180px; text-align: center;">
      <img src="https://secure.gravatar.com/avatar/3056b6827d3d959ea87306c4d2dd0c6a?s=800&d=identicon" width="100px;"/>
      <br/><sub><b>Daniel</b></sub><br>@heuvel
    </td>
  </tr>
</table>

# The Knowledge Bank | Website

## About the project

This is the website for The Knowledge Bank, a project by the [Open Knowledge Website](http://localhost:8080/).

## Directory structure model (SRC folder)

```bash
src/
├── main/
│   ├── java/
│   │   ├── com.all.knowledgebank/
│   │   │   ├── Configuration/
│   │   │   ├── Controller/
│   │   │   ├── DAO/
│   │   │   ├── Entity/
│   │   │   ├── Repository/
│   │   │   ├── Service/
│   │   │   ├── MainController.java
│   │   │   └── TheKnowledgeBankApplication.java
│   ├── resources/
│   │   ├── META-INF/
│   │   │   └── resources/
│   │   │   │   └── WEB-INF.views/
│   │   ├── static/
│   │   │   ├── css/
│   │   │   ├── icons/
│   │   │   ├── js/
│   │   │   └── favicon.ico
├── └── └── application.properties
└── test/
    └── java/
        └── com.all.knowledgebank/
            └── TheKnowledgeBankApplicationTests.java
```

## Directory structure model (Generated folder)

```bash
PROJ-PJ07.../
├── .mvn/Wrappers
├── src/...
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
├── package.json
├── tailwind.config.js
├── pom.xml
└── README.md
```

## Structural details

`com.all.knowledgebank/`
- `Configuration` - Chứa các class cấu hình cho project.
- `Controller` - Chứa các class controller để xử lý các request từ client.
- `DAO` - Chứa các DAO class để xử lý các thao tác với database.
- `Entity` - Chứa các class entity tương ứng với các bảng trong database.
- `Repository` - Chứa các interface base repository chung cho các DAO khác.
- `Service` - Chứa các class service để xử lý các thao tác logic.

## How to install the project

- Download Source: pom.xml
- Open the project in your IDE
- Run the project
- Open your browser and go to: http://localhost:8080/
- Enjoy!

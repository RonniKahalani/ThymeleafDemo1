# Simple Spring Thymeleaf Demo
Shows how a modern server-side Java template engine for web and standalone environments. 
It allows you to create dynamic web pages using HTML, XML, and other formats, following the MVC patterns way of separating concerns in a Model-View-Controller way.

## Using features
- Controllers (HomeController and UserController).
- Model components like services, repositories and data entities.
- Thymeleaf v3.5.5 with HTML fragment templates, view code is written only once and reused.
- UI framework Bootstrap v5.3.3 with jQuery v1.7.3.
- Bootstrap Icons v1.10.5 + Font Awesome Icons v6.0.0.
- Local CSS and JavaScript files.
- Using media audio and video.
- Custom exception handler.
- Implementing the Spring Controller, Service, Repository and Entity concepts.
- Shows a feature using multi-language support (i18n), via locale specific messages_xx.properties files.

## Controllers endpoints
- Home - HTTP GET /
- List Users - HTTP GET - /user 
- Show Create User Form - HTTP GET /create
- Save User - HTTP POST - /user
- Show User - HTTP GET - /user/{id}
- Show Update User Form - HTTP GET /update/{id}
- Delete User - HTTP GET /delete/{id}
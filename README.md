# Stella 🧠

**Stella** is an AI-powered core framework written in **Java 21** using **Spring Boot** and **Spring AI**. It is designed to be extensible via a plugin system, enabling developers to build custom integrations like Twitch or Discord bots, with persistent contextual memory and prompt-based responses.

---

## ✨ Features

- ⚙️ **Plugin Support**  
  Drop-in `.jar` files into the `plugins/` folder — inspired by Bukkit-style plugin architecture.

- 🤖 **Spring AI Integration**  
  Connects to LLMs via Spring AI and supports prompt generation from incoming messages.

- 🧠 **Persistent Memory**  
  Remembers user conversations and general chat context using a fast local database (SQLite for now).

- 🏷️ **Platform-aware**  
  Supports multiple platforms (`DISCORD`, `TWITCH`, `OTHER`) to track memory per source.

- 💬 **PromptBuilder**  
  Dynamically constructs prompts using general + user-specific memory.

---

## 🚧 Development Status

> **Stella is currently in early development.**  
> While it's functional, it is **not production-ready** and may undergo frequent breaking changes.

---

## 📝 Planned Features

- [ ] Caching with Spring `@Cacheable` and Redis  [POTENTIALLY]
- [ ] Memory TTL and pruning strategies [PRIORITY]
- [ ] Built-in plugin examples for Twitch4J and Discord4J
- [ ] Vector memory or embedding support [PRIORITY]
- [ ] Plugin event lifecycle (onEnable/onDisable) [WIP]
- [ ] Web UI for management of AI and plugins. [TBD]

---

## 📦 Requirements

- Java 21+
- Maven
- SQLite (auto-created) or other JDBC-supported database

---

## 🧪 Running the App

```bash
./mvnw spring-boot:run
```

Then drop your plugin `.jar` files into the `plugins/` directory and restart the app.

---

## 📜 License

This project is licensed under the [GNU General Public License v3.0 (GPL-3.0)](https://www.gnu.org/licenses/gpl-3.0.en.html).

You are free to use, modify, and distribute this software under the terms of the license.  
Note that any software incorporating Stella (including plugins) must also be released under GPL-compatible terms.

---

## 🤝 Contributing

Contributions are welcome in the future! Once core functionality is stable, plugin developers and contributors will be invited to expand the ecosystem.

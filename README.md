# helpdesk-chatbot-spring-AI


elpdesk Chatbot using Spring AI

A Helpdesk Chatbot application built with Spring Boot, Spring AI, and LLM-powered conversation flows.
This project allows users to chat with a virtual assistant, and automatically creates helpdesk tickets based on user input.
Each ticket is tied to the user's email ID, which acts as the unique identifier and is mandatory for tracking progress.

🚀 Features
🔹 AI-Powered Chat Interface

Users can chat with a chatbot that understands issues and queries.

The chatbot intelligently asks for missing details such as email or issue description.

🔹 Automatic Ticket Creation

A new ticket is created automatically when a user reports an issue.

Ticket contains:

User email

Issue description

Timestamp

System-generated Ticket ID

🔹 Email-Based Ticket Tracking

Ticket updates & closure.

Users can check the status of existing tickets by providing their registered email ID.

The system retrieves all open or past tickets associated with that email.

🔹 Spring AI Integration

Uses Spring AI to interact with LLMs and generate conversational responses.

Ensures structured output from AI for ticket creation and conversation flow.

🛠️ Tech Stack

Backend:

Java 17+

Spring Boot

Spring AI

Spring Web

Spring Data

LLM Provider:

(Specify the provider used: OpenAI, Azure OpenAI, Ollama, etc.)

Database:

H2 / PostgreSQL / MySQL (based on your configuration)

📂 Project Structure
helpdesk-chatbot-spring-AI/
│
├── src/main/java/com/gauravsars/helpdesk/
│   ├── controller/          # REST and chat endpoints
│   ├── service/             # Chat and ticket generation logic
│   ├── model/               # Request, Response, Ticket entities
│   ├── repository/          # Data persistence layer
│   ├── config/              # Spring AI & application configurations
│   └── HelpdeskApplication  # Main entry point
│
├── src/main/resources/
│   ├── application.properties
│   └── prompts/             # LLM prompt templates
│
└── README.md

⚙️ Setup Instructions
1️⃣ Clone the Repository
git clone https://github.com/gauravsars/helpdesk-chatbot-spring-AI
cd helpdesk-chatbot-spring-AI

2️⃣ Configure API Keys

model: llama-3.1-8b-instant , please check yml file for all configurations.
      api-key: ${GROQ_API_KEY}  # <-- Use GROQ key, not OpenAI key
      base-url: https://api.groq.com/openai


(Update keys and model names based on your provider.)

3️⃣ Run the Application
mvn spring-boot:run

4️⃣ Access the Chatbot

The chatbot endpoint can be accessed via REST client (Postman, curl, browser UI if implemented).

Example request:

{
  "email": "user@example.com",
  "message": "My laptop is not working"
}

💬 How the Chatbot Works

User sends a message.

Chatbot analyses the content and checks if required fields (especially email) are available.

If an email is missing, chatbot asks for it.

If an issue is detected:

A ticket is automatically created.

Ticket ID is sent back to the user.

If the user requests:

The bot retrieves all tickets linked to the email ID.

🧪 Sample Response
{
  "reply": "Thanks! A new ticket has been created for your issue.",
  "ticketId": "TCK-20250212-001",
  "status": "CREATED"
}

🧱 Future Enhancements

Multi-turn conversation memory

Authentication & role-based dashboard

Integration with Jira, ServiceNow, Freshdesk

UI-based chat widget

🤝 Contributing

Contributions are welcome!

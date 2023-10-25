import React, { useState, useEffect } from "react";
import axios from "axios";

function App() {
  const [url, setUrl] = useState("");
  const [requestType, setRequestType] = useState("GET");
  const [requestBody, setRequestBody] = useState("");
  const [response, setResponse] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      let response;
      if (requestType === "GET") {
        response = await axios.get(url);
      } else if (requestType === "POST") {
        response = await axios.post(url, requestBody, {
          headers: {
            "Content-Type": "application/json",
          },
        });
      } else if (requestType === "PUT") {
        response = await axios.put(url, requestBody, {
          headers: {
            "Content-Type": "application/json",
          },
        });
      } else if (requestType === "DELETE") {
        response = await axios.delete(url);
      }

      setResponse(JSON.stringify(response.data, null, 2));
      console.log(response.data);
    } catch (error) {
      setResponse(JSON.stringify(error.response.data, null, 2));
    }
  };

  return (
    <div className="App">
      <h1>API Testing Tool</h1>
      <form onSubmit={handleSubmit}>
        <label>
          API URL:
          <input
            type="text"
            value={url}
            onChange={(e) => setUrl(e.target.value)}
          />
        </label>
        <br />
        <label>
          Request Type:
          <select
            value={requestType}
            onChange={(e) => setRequestType(e.target.value)}
          >
            <option value="GET">GET</option>
            <option value="POST">POST</option>
            <option value="PUT">PUT</option>
            <option value="DELETE">DELETE</option>
          </select>
        </label>
        <br />
        <label>
          Request Body:
          <textarea
            value={requestBody}
            onChange={(e) => setRequestBody(e.target.value)}
          />
        </label>
        <br />
        <button type="submit">Send Request</button>
      </form>
      <div>
        <h2>Response:</h2>
        <pre>{response}</pre>
      </div>
    </div>
  );
}

export default App;

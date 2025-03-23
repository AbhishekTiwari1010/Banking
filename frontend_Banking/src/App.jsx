import { useState } from 'react'

import './App.css'

import axios from "axios";

export default function BankingApp() {
  const [holderName, setHolderName] = useState("");
  const [amount, setAmount] = useState("");
  const [message, setMessage] = useState("");

  const handleRequest = async (endpoint) => {
    try {
      const response = await axios.post(`http://localhost:8080/bank/${endpoint}`, null, {
        params: { holderName, amount: amount || undefined },
      });
      setMessage(response.data);
    } catch (error) {
      setMessage("Error: " + error.response?.data || "Request failed");
    }
  };

  const getBalance = async () => {
    try {
      const response = await axios.get("http://localhost:8080/bank/balance", {
        params: { holderName },
      });
      setMessage(response.data);
    } catch (error) {
      setMessage("Error: " + error.response?.data || "Request failed");
    }
  };

  return (
    <div className="p-6 max-w-md mx-auto bg-white rounded-xl shadow-md space-y-4">
      <h2 className="text-xl font-bold">Banking System</h2>
      <input
        type="text"
        placeholder="Account Holder Name"
        value={holderName}
        onChange={(e) => setHolderName(e.target.value)}
        className="border p-2 w-full"
      />
      <input
        type="number"
        placeholder="Amount (if applicable)"
        value={amount}
        onChange={(e) => setAmount(e.target.value)}
        className="border p-2 w-full"
      />
      <div className="space-y-2">
        <button className="bg-blue-500 text-white p-2 w-full rounded" onClick={() => handleRequest("createAccount")}>
          Create Account
        </button>
        <button className="bg-green-500 text-white p-2 w-full rounded" onClick={() => handleRequest("deposit")}>
          Deposit
        </button>
        <button className="bg-red-500 text-white p-2 w-full rounded" onClick={() => handleRequest("withdraw")}>
          Withdraw
        </button>
        <button className="bg-gray-500 text-white p-2 w-full rounded" onClick={getBalance}>
          Check Balance
        </button>
      </div>
      {message && <p className="mt-4 p-2 bg-gray-100">{message}</p>}
    </div>
  );
}

// function App() {
//   const [count, setCount] = useState(0)

//   return (
//     <>
      
//     </>
//   )
// }

// // export default Ap

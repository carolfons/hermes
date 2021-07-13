import React, { useState } from 'react'
import { Link, useHistory } from 'react-router-dom'
import { FiLogIn } from 'react-icons/fi'

import api from '../../services/api'

import './styles.css'

import logoImg from '../../assets/logo.png'
import heroesImg from '../../assets/heroes.png'

export default function Logon() {
  const [id, setId] = useState('')
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const history = useHistory()

  async function handleLogin(e) {
    e.preventDefault()
    try {
      const response = await api.post('sessions', { email, password })

      localStorage.setItem('email', email)
      localStorage.setItem('password', password)
      localStorage.setItem('ongName', response.data.name)

      history.push('/usuarios')
    } catch (err) {
      alert('Falha no login, tente novamente.')
    }
  }

  return (
    <div className="logon-container">
      <section className="form">
        <img src={logoImg} alt="Hermes Logo" />

        <form onSubmit={handleLogin}>
          <h1> Faça seu Login </h1>
          <input placeholder="Seu Email" value={id} onChange={e => setId(e.target.value)} />
          <input type="password" placeholder="Senha" value={id} />
          <button className="button" type="submit"> Entrar </button>
          <Link className="back-link" to="/register">
            <FiLogIn size={16} color="#006BE2" />
          Não tenho cadastro
        </Link>
        </form>
      </section>
      <img className="principalImage" src={heroesImg} alt="helpers" />
    </div>
  )
}
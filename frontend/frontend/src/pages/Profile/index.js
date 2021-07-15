import React, { useState, useEffect } from 'react'
import { Link, useHistory } from 'react-router-dom'
import { FiPower, FiTrash2 } from 'react-icons/fi'

import api from '../../services/api'

import './styles.css'

import logoImg from '../../assets/logo.png'

export default function Profile() {

  const [incidents, setIncidents] = useState([])
  const history = useHistory()
  const ongId = localStorage.getItem('ongId')
  const nomeUsuario = localStorage.getItem('userName')
  const usuario = localStorage.getItem('usuario')
  //console.log(usuario.data)
  // const ongName = localStorage.getItem('ongName')

  useEffect(() => {
    api.get('ongs', {
      // headers: {
      //   Authorization: ongId,
      // }
    }).then(response => {
      setIncidents(response.data)
    })
  }, [ongId])

  // async function handleDeleteIncident(id) {
  //   try {
  //     await api.delete(`incidents/${id}`, {
  //       headers: {
  //         Authorization: ongId,
  //       }
  //     })

  //     setIncidents(incidents.filter(incident => incident.id !== id))
  //   } catch (err) {
  //     alert('Erro ao deletar caso, tente novamente.')
  //   }
  // }

  function handleLogout() {
    localStorage.clear()
    history.push('/')
  }

  return (
    <div className="profile-container">
      <header>
        <img src={logoImg} alt="logo" />
        <span> Olá <p> {nomeUsuario}</p></span>

        <Link className="button" to="/incidents/new" roles={"ROLE_ADMIN"}> Cadastrar novo caso </Link>
        <button onClick={handleLogout} type="button">
          <FiPower size={18} color="006BE2" />
        </button>
      </header>
      <h1> Casos Cadastrados </h1>
      <ul>
        {incidents.map(incident => (
          <li key={incident.id}>
            <strong> CASO: </strong>
            <p> {incident.name} </p>

            <strong> DESCRIÇÃO: </strong>
            <p> {incident.description} </p>

            <strong> DESCRIÇÃO: </strong>
            <p> {incident.phone} </p>

            <strong> ENDEREÇO: </strong>
            <p> {incident.address} </p>

            {/* <strong> VALOR: </strong>
            <p> {Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(incident.value)} </p> */}

            {/* <button onClick={() => handleDeleteIncident(incident.id)} type="button">
              <FiTrash2 size={20} color="#a8a8b3" />
            </button> */}
          </li>
        ))}
      </ul>
    </div>
  )
}
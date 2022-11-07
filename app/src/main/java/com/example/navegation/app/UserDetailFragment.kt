package com.example.navegation.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.navegation.databinding.FragmentUserdetailBinding


class UserDetailFragment : Fragment() {
    private var _binding: FragmentUserdetailBinding? = null
    private val binding get() = _binding!!
    val args: UserDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserdetailBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvIdUsuario: TextView = binding.userId
        val tvNombreUsuario: TextView = binding.userName
        val tvEmailUsuario: TextView = binding.userEmail
        val tvUsernameUsuario: TextView = binding.userUsername
        val tvPhoneUsuario: TextView = binding.userPhone
        val tvWebsiteUsuario: TextView = binding.userWebsite
        /*val tvWebsiteCompany: TextView = binding.userCompany*/

        tvIdUsuario.text = args.user.id.toString()
        tvNombreUsuario.text = args.user.name
        tvEmailUsuario.text = args.user.email
        tvUsernameUsuario.text = args.user.username
        tvPhoneUsuario.text = args.user.phone
        tvWebsiteUsuario.text = args.user.website
        /*tvWebsiteCompany.text = args.user.company.name*/



    }
}
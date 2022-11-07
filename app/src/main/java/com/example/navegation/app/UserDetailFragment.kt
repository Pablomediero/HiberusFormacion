package com.example.navegation.app

import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
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
        val tvIdUsuario      : TextView = binding.userId
        val tvNombreUsuario  : TextView = binding.userName
        val tvEmailUsuario   : TextView = binding.userEmail
        val tvUsernameUsuario: TextView = binding.userUsername
        val tvPhoneUsuario   : TextView = binding.userPhone
        val tvWebsiteUsuario : TextView = binding.userWebsite
        val tvAddressUsuario : TextView = binding.userAddress
        val tvWebsiteCompany : TextView = binding.userCompany
        val llAlbum          : LinearLayout = binding.llAlbums

        tvIdUsuario.text        = args.user.id.toString()
        tvNombreUsuario.text    = args.user.name
        tvEmailUsuario.text     = args.user.email
        tvUsernameUsuario.text  = args.user.username
        tvPhoneUsuario.text     = args.user.phone
        tvWebsiteUsuario.text   = args.user.website
        tvAddressUsuario.text   = args.user.address.city + " - " +args.user.address.street
        tvWebsiteCompany.text   = args.user.company.name + " - " +args.user.company.bs

        var aux = 1
        args.user.albums.forEach { album ->
            val tvNombreAlbumTV = TextView(context)
            val tvNombreAlbum = TextView(context)

            tvNombreAlbumTV.text = "Album "+ aux++
            tvNombreAlbumTV.setTypeface(Typeface.DEFAULT_BOLD);
            tvNombreAlbumTV.textSize = 20f

            tvNombreAlbum.text = album.title
            tvNombreAlbum.textSize = 20f

            val width = 1000
            val height = 1000
            val parms = LinearLayout.LayoutParams(width, height)

            llAlbum.addView(tvNombreAlbumTV)
            llAlbum.addView(tvNombreAlbum)

            album.photos.forEachIndexed { index, photo ->
                if (index == 1) {
                    return@forEach
                }
                val ivPhotoUrl = ImageView(context)
                Log.i("Async", photo.thumbnailURL)
                val theImage = GlideUrl(
                    photo.thumbnailURL, LazyHeaders.Builder()
                        .addHeader("User-Agent", "5")
                        .build()
                )
                Glide.with(this).load(theImage).into(ivPhotoUrl)
                ivPhotoUrl.setLayoutParams(parms)
                llAlbum.addView(ivPhotoUrl)

            }


        }




    }
}